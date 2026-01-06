import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] drownArea;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		int max = 0;
		for(int i = 0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int maxArea = 0;
		for(int i = 1; i <= max; i++){
			drown(i);
			int area = 0;
			for(int j = 0; j<n; j++){
				for(int k = 0; k<n; k++){
					if(drownArea[j][k]) continue;
					bfs(j,k);
					area+=1;
				}
			}
			if(area == 0)
				area = 1;
			maxArea = Math.max(maxArea, area);
		}

		System.out.println(maxArea);
	}
	public static void drown(int level){
		drownArea = new boolean[n][n];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(map[i][j] <= level)
					drownArea[i][j] = true;
			}
		}
	}
	public static void bfs(int x, int y){
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		drownArea[x][y] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0]; int cy = cur[1];

			for(int i = 0; i<4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(drownArea[nx][ny]) continue;

				q.add(new int[] {nx, ny});
				drownArea[nx][ny] = true;
			}
		}

	}
}
