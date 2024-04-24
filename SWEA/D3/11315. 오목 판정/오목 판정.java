
import java.io.*;
import java.util.*;

class Solution {
	static int[][] map;
	static int n;
	static int[] dx = {1,-1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,1,-1,1,-1,1,-1};
	static int answer;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			Queue<int[]> q = new LinkedList<>();
			
			for(int i = 0; i<n; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<n; j++) {
					if(str[j].equals("o")) {
						map[i][j] = 1;
						q.add(new int[] {i,j});
					}
				}
			}
			
			answer = 0;
			while(!q.isEmpty()) {
				int[] poll = q.poll();
				solve(poll[0], poll[1]);
				if(answer == 1)
					break;
			}
			
			if(answer == 1)
				bw.write(String.format("#%d YES\n", test_case));
			else
				bw.write(String.format("#%d NO\n", test_case));
			
		} // end of testcase
		bw.flush();
	}
	public static void solve(int x, int y) {
		// 8방향 검사
		for(int i = 0; i<8; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			
			if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1) {
				continue;
			}
			
			// 만약 'o'이라면
			if(map[nextx][nexty] == 1) {
				dfs(nextx, nexty, dx[i], dy[i], 2);
				if(answer == 1)
					break;
			}
			
		}
	}
	public static void dfs(int x, int y, int dx, int dy, int count) {
		int nextx = x+dx; int nexty = y+dy;
		if(count >= 5) {
			answer = 1;
			return;
		}
		if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1)
			return;
		
		if(map[nextx][nexty] == 1) {
			dfs(nextx, nexty, dx, dy, count+1);
		}
		
	}
}
