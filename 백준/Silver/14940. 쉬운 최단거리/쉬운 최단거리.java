import java.io.*;
import java.util.*;

public class Main {

	public static int[][] map;
	public static boolean[][] visit;
	public static int n;
	public static int m;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception  {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		int startX=0; int startY=0;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startX = i; startY = j;
				}
			}
		}
	
		bfs(startX, startY);
		checkInaccessible(startX, startY);
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static void bfs(int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startX,startY});
		visit[startX][startY] = true;
		map[startX][startY] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if(map[nextX][nextY] == 0 || visit[nextX][nextY] == true) {
					continue;
				}
				q.add(new int[] {nextX,nextY});
				visit[nextX][nextY] = true;
				map[nextX][nextY] = map[nowX][nowY] + 1;
			}
		}
	}
	
	public static void checkInaccessible(int startX, int startY) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					map[i][j] = -1;
				}
			}
		}
		
	}
}
