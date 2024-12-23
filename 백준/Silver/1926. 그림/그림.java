import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visit;
	static int[][] map;
	static int n, m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max = 0;
	static int picCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					max = Math.max(bfs(i,j), max);
				}
			}
		}
		
		System.out.println(picCount);
		System.out.println(max);
	}
	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y});
		picCount += 1;
		int count = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int curx = poll[0];
			int cury = poll[1];
			count += 1;
			
			for(int i = 0; i<4; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				
				if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				if(visit[nextx][nexty] || map[nextx][nexty] == 0) {
					continue;
				}
				
				q.add(new int[] {nextx, nexty});
				visit[nextx][nexty] = true;
			}
		}
		
		return count;
	}
}