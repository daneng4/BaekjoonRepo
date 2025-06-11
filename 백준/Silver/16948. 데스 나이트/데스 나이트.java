import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2,-2,0,0,2,2};
	static int[] dy = {-1,+1,-2,+2,-1,+1};
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		int r1 = 0;
		int c1 = 0;
		int r2 = 0;
		int c2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		bfs(r1, c1, r2, c2);
		if(map[r2][c2] == 0)
			System.out.println(-1);
		else
			System.out.println(map[r2][c2]);
	}
	public static void bfs(int r1, int c1, int r2, int c2){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r1, c1});

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			if(cx == r2 && cy == c2){
				break;
			}

			for(int i = 0; i<6; i++){
				int nx = cx+dx[i];
				int ny = cy+dy[i];

				if(nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if(map[nx][ny] != 0)
					continue;

				q.add(new int[] {nx, ny});
				map[nx][ny] = map[cx][cy] + 1;
			}
		}

	}
}
