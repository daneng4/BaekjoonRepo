import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];

		for(int i = 0; i<n; i++){
			String str = br.readLine();
			for(int j = 0; j<m; j++){
				map[i][j] = str.charAt(j);
			}
		}

		int wpower = 0;
		int bpower = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(map[i][j] == 'W' && !visit[i][j]){
					int result = bfs(i, j, 'W');
					wpower += (int)Math.pow(result, 2);
				}
			}
		}

		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(map[i][j] == 'B' && !visit[i][j]){
					int result = bfs(i, j, 'B');
					bpower += (int)Math.pow(result, 2);
				}
			}
		}

		System.out.println(wpower + " " + bpower);
	}
	public static int bfs(int x, int y, char word){
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x,y});
		int count = 0;

		while(!q.isEmpty()){
			int[] point = q.poll();
			count+=1;

			for(int i = 0; i<4; i++){
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];

				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(visit[nx][ny])
					continue;

				if(map[nx][ny] == word){
					q.add(new int[] {nx,ny});
					visit[nx][ny] = true;
				}
			}
		}

		return count;
	}
}
