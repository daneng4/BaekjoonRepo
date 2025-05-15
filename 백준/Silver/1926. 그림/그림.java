import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];

		int count = 0;
		int size = 0;

		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j <m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(visit[i][j] || map[i][j] == 0)
					continue;

				size = Math.max(size, bfs(i,j));
				count++;
			}
		}

		System.out.println(count + "\n" + size);

	}
	public static int bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		int result = 0;

		while(!q.isEmpty()){
			int[] pos = q.poll();
			int curx = pos[0];
			int cury = pos[1];

			if(map[curx][cury] == 1){
				result+=1;
			}

			for(int i = 0; i<4; i++){
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];

				if(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && !visit[nextx][nexty] && map[nextx][nexty] == 1){
					q.add(new int[] {nextx, nexty});
					visit[nextx][nexty] = true;
				}
			}
		}

		return result;
	}
}
