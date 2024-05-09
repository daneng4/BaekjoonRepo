import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = 10;
		
		for(int t = 1; t<=test_case; t++) {
			int testCaseNumber = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visit = new boolean[100][100];
			int startx = 0; int starty = 0;
			int endx = 0; int endy = 0;
			
			for(int i = 0; i<100; i++) {
				String str = br.readLine();
				for(int j = 0; j<100; j++) {
					map[i][j] = str.charAt(j)-'0';
					
					if(map[i][j] ==  2) {
						startx = i;
						starty = j;
					}else if(map[i][j] == 3) {
						endx = i;
						endy = j;
					}
				}
			}
			
			if(bfs(startx, starty, endx, endy)) {
				bw.write(String.format("#%d 1\n", testCaseNumber));
			}else {
				bw.write(String.format("#%d 0\n", testCaseNumber));
			}
			
		} // testcase
		bw.flush();
			
	}
	public static boolean bfs(int startx, int starty, int endx, int endy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startx, starty});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int curx = poll[0]; int cury = poll[1];
			if(visit[curx][cury])
				continue;
			visit[curx][cury] = true;
			if(curx == endx && cury == endy)
				return true;
			
			for(int i = 0; i<4; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				
				if(nextx < 0 || nexty < 0 || nextx > 99 || nexty > 99)
					continue;
				if(visit[nextx][nexty] || map[nextx][nexty] == 1)
					continue;
				
				q.add(new int[] {nextx, nexty});
			}
			
		}
		
		return false;
	}
}
