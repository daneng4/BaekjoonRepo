
import java.io.*;
import java.util.*;

class Solution {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answerNumber, answer;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[n][n];
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answerNumber = 0; 
			answer = 0;
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					dfs(i,j, map[i][j], 1);
					visit[i][j] = false;
				}
			}

			bw.write(String.format("#%d %d %d\n", test_case, answerNumber, answer));
		} // end of testcase
		bw.flush();
	}
	public static void dfs(int x, int y, int startNumber, int depth) {
		visit[x][y] = true;
		
		// 상하좌우 탐색
		for(int i = 0; i<4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			
			if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1) {
				continue;
			}
			if(visit[nextx][nexty] || map[nextx][nexty] != map[x][y] + 1)
				continue;
			
			dfs(nextx, nexty, startNumber, depth+1);
			visit[nextx][nexty] = false;
		}
		
		// 더이상 전진이 불가능한 경우
		// 이동한 방의 개수가 answer보다 크면 answer 갱신, startNumber 갱신
		// 이동한 방의 개수가 같다면 startNumber와 answerNumber 중 작은 것으로 갱신
		if(depth > answer) {
			answer = depth;
			answerNumber = startNumber;
		}else if(depth == answer) {
			answerNumber = Math.min(startNumber, answerNumber);
		}
		
	}
}
