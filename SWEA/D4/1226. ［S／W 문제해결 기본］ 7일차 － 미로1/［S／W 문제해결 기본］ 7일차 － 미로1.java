
import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = 10;
		for(int t = 1; t<=test_case; t++) {
			int test_num = Integer.parseInt(br.readLine());
			map = new int[16][16];
			visit = new boolean[16][16];
			
			int startx=0, starty=0, endx=0, endy=0;
			for(int i = 0; i<16; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<16; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if(map[i][j] == 2) {
						startx = i; starty = j;
					}else if(map[i][j] == 3) {
						endx = i; endy = j;
					}
				}
			}
			
			answer = 0;
			bfs(startx, starty, endx, endy);
			bw.write(String.format("#%d %d\n", test_num, answer));
		}// end of tc
		bw.flush();
	}
	public static void bfs(int startx, int starty, int endx, int endy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startx, starty});
		visit[startx][starty] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int curx = poll[0]; int cury = poll[1];
			
			if(curx == endx && cury == endy) {
				answer = 1;
				break;
			}
			
			for(int i = 0; i<4; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				
				if(nextx < 0 || nexty < 0 || nextx > 15 || nexty > 15)
					continue;
				if(visit[nextx][nexty] || map[nextx][nexty] == 1)
					continue;
				
				visit[nextx][nexty] = true;
				q.add(new int[] {nextx, nexty});
			}
			
		}
		
	}
}
