
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a-1][b-1] = 1;
		}
		
		int maxSize = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] != 1)
					continue;
				int[] position = {i,j};
				int curSize = bfs(position);
				maxSize = Math.max(maxSize, curSize);
			}
		}
		System.out.println(maxSize);
	}
	public static int bfs(int[] pos) {
		int size = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(pos);
		visit[pos[0]][pos[1]] = true;
		
		while(!q.isEmpty()) {
			
			int[] curPos = q.poll();
			int curX = curPos[0];
			int curY = curPos[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX > n-1 || nextY > m-1)
					continue;
				if(visit[nextX][nextY])
					continue;
				
				if(map[nextX][nextY] == 1) {
					q.add(new int[] {nextX, nextY});
					visit[nextX][nextY] = true;
					size+=1;
				}
				
			}
			
		} // end of while
		
		return size;
	}
}




