

import java.util.*;
import java.io.*;


public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int result;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			visit = new boolean[n][m];
			result = 0;
			Queue<int[]> q = new LinkedList<>();
			for(int i = 0; i<n; i++) {
				String mapInfo = br.readLine();
				for(int j = 0; j<m; j++) {
					map[i][j] = mapInfo.charAt(j);
					if(map[i][j] == '#')
						q.offer(new int[] {i,j});
				}
			}
			while(!q.isEmpty()) {
				int[] pos = q.poll();
				int x = pos[0]; int y = pos[1];
				if(visit[x][y])
					continue;
				solve(x,y);
			}
			sb.append(result).append("\n");
		}// end of tc
		System.out.println(sb);
	}
	public static void solve(int x, int y) {
		Queue<int[]> qq = new LinkedList<>();
		qq.offer(new int[] {x,y});
		visit[x][y] = true;
		
		while(!qq.isEmpty()) {
			int[] cur = qq.poll();
			int curx = cur[0];
			int cury = cur[1];
			
			for(int i = 0; i<4; i++) {
				int nextx = curx+dx[i];
				int nexty = cury+dy[i];
				
				if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > m-1)
					continue;
				if(visit[nextx][nexty] || map[nextx][nexty] == '.')
					continue;
				
				visit[nextx][nexty] = true;
				qq.offer(new int[] {nextx, nexty});
			}
		}
		result++;
	}
}
