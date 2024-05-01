
import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> core;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n, maxConnect, minLen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[n][n];
			core = new ArrayList<>();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						visit[i][j] = true;
						// 가장자리가 아닌 코어 저장
						if(0<i && i<n-1 && 0<j && j<n-1) {
							core.add(new int[] {i,j});
						}
					}
					
				}
			}
			maxConnect = 0;
			minLen = Integer.MAX_VALUE;
			solve(0,0,0);
			
			bw.write(String.format("#%d %d\n", t, minLen));
		}
		
		bw.flush();
	}
	// 탐색한 코어 개수, 전선 길이. 연결된 코어 개수
	public static void solve(int count, int len, int connect) {
		// 모든 코어에 대해서 탐색을 마쳤다면
		if(count == core.size()) {
			// 현재 연결된 개수가 answer보다 많으면
			if(connect > maxConnect) {
				maxConnect = connect;
				minLen = len;
			} // 연결 개수가 같으면
			else if(connect == maxConnect) {
				minLen = Math.min(len, minLen);
			}
			return;
		}
		
		for(int i = 0; i<4; i++) {
			int curLen = connecting(core.get(count), dx[i], dy[i]);
			// 연결되지 못한 코어인 경우
			if(curLen == 0) {
				solve(count+1, len, connect);
			}
			else {
				solve(count+1, len+curLen, connect+1);
				// 다른 경우 탐색을 위한 연결 정보(visit) 초기화
				initVisit(core.get(count), dx[i], dy[i]);
			}
		}
		
	}
	public static int connecting(int[] pos, int dx, int dy) {
		int x = pos[0]; int y = pos[1];
		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		
		while(true) {
			int nextx = x + dx;
			int nexty = y + dy;
			
			// x or y가 벽에 닿을때 까지 진행
			if(nextx < 0 || nextx > n-1 || nexty < 0 || nexty > n-1)
				break;
			
			// 다른 전선 or 코어에 닿으면 이쪽 방향으론 연결 할 수 없는 것
			// 담아놨던 방문 정보를 전부 초기화하고 0을 리턴한다.
			if(visit[nextx][nexty]) {
				while(!q.isEmpty()) {
					int[] poll = q.poll();
					int vx = poll[0];
					int vy = poll[1];
					visit[vx][vy] = false;
				}
				return 0;
			}
			visit[nextx][nexty] = true;
			q.add(new int[] {nextx,nexty});
			x += dx;
			y += dy;
			count++;
		}
		
		return count;
	}
	public static void initVisit(int[] pos, int dx, int dy) {
		int x = pos[0]; int y = pos[1];
		
		while(true) {
			int nextx = x+dx;
			int nexty = y+dy;
			
			// x or y가 벽에 닿을때 까지 진행
			if(nextx < 0 || nextx > n-1 || nexty < 0 || nexty > n-1)
				break;

			visit[nextx][nexty] = false;
			x += dx;
			y += dy;
		}
	}
}