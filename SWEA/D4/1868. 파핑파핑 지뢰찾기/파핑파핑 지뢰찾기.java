
import java.io.*;
import java.util.*;

class Solution {
	static int n;
	static int[][] map;
	static boolean[][] visit;
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
			visit = new boolean[n][n];
			Queue<int[]> q = new LinkedList<>();
			
			for(int i = 0; i<n; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<n; j++) {
					if(str[j].equals("*")) {
						map[i][j] = 1;
						q.add(new int[] {i,j});
					}
				}
			}
			
			answer = 0;
			// 지뢰 주변 좌표 파악
			nearBomb(q);
			// 지뢰가 아니고 지뢰 주변이 아닌 곳은 눌렀을 때 0이 나오는 좌표
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(map[i][j] == 1 || map[i][j] == 2 || visit[i][j])
						continue;
					checkZeroPoint(i, j);
					answer++;
				}
			}
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					// 지뢰가 아니고, visit을 하지 않은 좌표면 answer+1
					if(map[i][j] != 1 && !visit[i][j])
						answer++;
				}
			}
			
			bw.write(String.format("#%d %d\n", test_case, answer));
		} // end of testcase
		bw.flush();
	}
	public static void nearBomb(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int i = 0; i<8; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				
				// 맵을 벗어나거나 지뢰가 있다면 패스
				if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1)
					continue;
				if(map[nextx][nexty] == 1)
					continue;
				
				map[nextx][nexty] = 2;
			}
			
		}
	}
	public static void checkZeroPoint(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int curx = poll[0];
			int cury = poll[1];
			
			if(visit[curx][cury])
				continue;
			visit[curx][cury] = true;
			
			// 0의 주변을 오픈, 오픈시 다른 0이 발견되면 큐에 삽입
			for(int i = 0; i<8; i++) {
				int nextx = curx+dx[i];
				int nexty = cury+dy[i];
				
				// 맵 밖을 벗어나거나 지뢰가 있으면 패스
				if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1) {
					continue;
				}
				if(map[nextx][nexty] == 1)
					continue;
				
				// next 좌표가 0인지 검사
				if(checkIsZero(nextx,nexty)) {
					q.add(new int[] {nextx, nexty});
				}else {
					visit[nextx][nexty] = true;
				}
			}
			
		}
		
	}
	public static boolean checkIsZero(int x, int y) {
		for(int i = 0; i<8; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			
			if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > n-1)
				continue;
			
			// 지뢰가 있다면 이 좌표는 0이 될 수 없음
			if(map[nextx][nexty] == 1)
				return false;
		}
		return true;
	}
}
