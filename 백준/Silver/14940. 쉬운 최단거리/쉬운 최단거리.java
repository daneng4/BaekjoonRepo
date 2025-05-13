import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int startX = 0;
		int startY = 0;
		map = new int[n][m];
		dist = new int[n][m];
		visit = new boolean[n][m];

		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2){
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(map[i][j] == 0){
					sb.append(0 + " ");
					continue;
				}
				if(!visit[i][j]){
					sb.append(-1 + " ");
					continue;
				}
				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	public static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		dist[x][y] = 0;
		visit[x][y] = true;

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int curX = poll[0];
			int curY = poll[1];


			for(int i = 0; i<4; i++){
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m && !visit[nextX][nextY] && map[nextX][nextY] != 0){
					dist[nextX][nextY] = dist[curX][curY] + 1;
					q.add(new int[] {nextX, nextY});
					visit[nextX][nextY] = true;
				}
			}
		}

	}
}
