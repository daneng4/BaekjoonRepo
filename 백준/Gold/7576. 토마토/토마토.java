import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static Queue<int[]> q;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		q = new LinkedList<>();

		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					q.add(new int[]{i,j});
			}
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for(int i = 0; i<4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(map[nx][ny] != 0)
					continue;

				q.add(new int[]{nx, ny});
				map[nx][ny] = map[cx][cy] + 1;
			}
		}

		int answer = 0;

		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(map[i][j] == 0){
					System.out.println("-1");
					return;
				}
				answer = Math.max(answer, map[i][j]);
			}
		}

		System.out.println(answer-1);
	}
}
