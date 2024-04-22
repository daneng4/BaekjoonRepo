
import java.io.*;
import java.util.*;

class Solution {
	static int[][] map;
	static int[] dx = {1,-1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,1,-1,1,-1,1,-1};
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			map = new int[n+1][n+1];
			// 맵 초기화, 정가운데 흑백돌 배치
			initMap();
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				
				map[x][y] = color;
				check(x,y,color);
			}
			int white = 0; // 2
			int black = 0; // 1
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(map[i][j] == 1)
						black++;
					else if(map[i][j] == 2)
						white++;
				}
			}
			
			bw.write(String.format("#%d %d %d\n", test_case, black, white));
		} // end of testcase
		bw.flush();
	}
	
	public static void initMap() {
		// (n/2-1,n/2-1) = 백
		// 1이면 흑, 2면 백돌
		
		map[n/2][n/2] = 2;
		map[n/2+1][n/2] = 1;
		map[n/2][n/2+1] = 1;
		map[n/2+1][n/2+1] = 2;
	}
	public static void check(int x, int y, int color) {
		// 현재 좌표에서 8방향을 검사
		// 만약 퐁당퐁 으로 놓여져 있다면 가운데 돌은 현재 좌표 돌과 같아짐
		
		for(int i = 0; i<8; i++) {
			int nextx = x+dx[i];
			int nexty = y+dy[i];
			
			boolean isMine = false;
			while(nextx >= 1 && nexty >= 1 && nextx <= n && nexty <= n && map[nextx][nexty] != 0) {
				if(map[nextx][nexty] == color) {
					isMine = true;
					break;
				}
				
				nextx += dx[i];
				nexty += dy[i];
			}
			
			while(isMine) {
				if(nextx == x && nexty == y) {
					break;
				}
				map[nextx][nexty] = color;
				nextx -= dx[i];
				nexty -= dy[i];
			}
			
			
		}
		
	}
}
