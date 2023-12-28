
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static int result;
	static ArrayList<int[]> list, home;
	static boolean[] open;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // 살아남은 치킨집 m개
		
		map = new int[n][n];
		list = new ArrayList<>();
		home = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new int[] {i,j});
				}else if (map[i][j] == 2) {
					list.add(new int[] {i,j});
				}
			}
		}
		result = Integer.MAX_VALUE;
		open = new boolean[list.size()];
		findChicken(0,0);
		System.out.println(result);
	}
	public static void findChicken(int start, int depth) {
		if(depth == m) {
			getChickenLoad(); // 치킨 거리 구하기
			return;
		}
		
		for(int i = start; i<list.size(); i++) {
			open[i] = true;
			findChicken(i+1, depth+1);
			open[i] = false;
		}
		
	}
	
	public static void getChickenLoad() {
		int currTotal = 0; // 현재 선정한 치킨집으로 인해 구해진 도시의 치킨거리의 총 길이
		// 각 집(home) 과 치킨집(list)를 거리 비교하여 최소 값을 구함
		for(int i = 0; i<home.size(); i++) {
			int minLoad = Integer.MAX_VALUE; // 한 집의 가장 짧은 치킨 거리
			for(int j = 0; j<list.size(); j++) {
				if(open[j]) {
					int distance = Math.abs(home.get(i)[0] - list.get(j)[0]) + 
							Math.abs(home.get(i)[1] - list.get(j)[1]);
					minLoad = Math.min(distance, minLoad);
				}
			}
			currTotal += minLoad;
		}
		result = Math.min(result, currTotal);
		
	}
}

