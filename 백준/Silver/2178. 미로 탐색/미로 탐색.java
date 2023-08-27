
import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] moveX = {1,-1,0,0};
	static int[] moveY = {0,0,1,-1};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		// map을 2차원 배열로 만들기
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			char[] mapData = str.toCharArray();
			for(int j = 0; j<m; j++) {
				map[i][j] = mapData[j] - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(map[n-1][m-1]);
		
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = nowX + moveX[i];
				int nextY = nowY + moveY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				
				if(visited[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}
				
				q.add(new int[] {nextX, nextY});
				map[nextX][nextY] = map[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
		
		
	}
}


