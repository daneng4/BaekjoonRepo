import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visit;
	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
			
		bfs(0,0);
		System.out.println(map[n-1][m-1]);
	}
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int nowx = poll[0];
			int nowy = poll[1];
			
			if(visit[nowx][nowy]) continue;
			visit[nowx][nowy] = true;
			
			for(int i = 0; i<4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				
				if(nextx < 0 || nexty < 0 || nextx > n-1 || nexty > m-1)
					continue;
				
				if(map[nextx][nexty] == 1 && !visit[nextx][nexty]) {
					if(map[nextx][nexty] == 1)
						map[nextx][nexty] = map[nowx][nowy] + 1;
					else
						map[nextx][nexty] = Math.min(map[nextx][nexty], map[nowx][nowy] + 1);
					q.add(new int[] {nextx, nexty});
				}
				
			}
			
		}
		
	}
}
