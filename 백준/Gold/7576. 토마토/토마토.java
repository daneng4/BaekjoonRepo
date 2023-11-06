
import java.io.*;
import java.util.*;

public class Main {

	static int map[][];
	static boolean visit[][];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<int[]> q = new LinkedList<>();
	static int n, m;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}

		tomato();
		if(check()) {
			System.out.println("-1");
		}else {
			getMax();
			System.out.println(max);
		}
	}
	
	public static void tomato() {
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for(int i = 0; i<4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if(map[nextX][nextY] == -1 || visit[nextX][nextY]) {
					continue;
				}
				
				if(map[nextX][nextY] == 0) {
					map[nextX][nextY] = map[x][y] + 1;
					q.offer(new int[] {nextX, nextY});
				}
			}	
		}
		
	}
	
	public static boolean check() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void getMax() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(max<map[i][j])
					max = map[i][j];
			}
		}
		max = max-1;
	}
}
