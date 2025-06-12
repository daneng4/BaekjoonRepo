import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int r, c;
	static int sheep, wolf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visit = new boolean[r][c];
		sheep = 0;
		wolf = 0;

		for(int i = 0; i<r; i++){
			String str = br.readLine();
			for(int j = 0; j<c; j++){
				map[i][j] = str.charAt(j);
			}
		}

		for(int i = 0; i<r; i++){
			for(int j = 0; j<c; j++){
				if(map[i][j] != '#' && !visit[i][j]){
					isSheepWin(i,j);
				}
			}
		}

		System.out.println(sheep + " " + wolf);

	}
	public static void isSheepWin(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;

		int s = 0;
		int w = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			if(map[cx][cy] == 'v')
				w++;
			else if(map[cx][cy] == 'k')
				s++;

			for(int i = 0; i<4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if(map[nx][ny] == '#' || visit[nx][ny])
					continue;

				q.add(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}

		if(s > w)
			sheep += s;
		else
			wolf += w;
	}
}
