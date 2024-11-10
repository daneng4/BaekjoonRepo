
import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int safeArea = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setWall(0, map);
		System.out.println(safeArea);
	}
	static void setWall(int wallCount, int[][] map) {
		if(wallCount == 3) {
			getSafeArea(map);
			return;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					setWall(wallCount + 1, map);
					map[i][j] = 0;
				}
			}
		}
		
	}
	static void getSafeArea(int[][] map) {
		int[][] simulMap = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				simulMap[i][j] = map[i][j];
			}
		}
		
		simulation(simulMap);
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(simulMap[i][j] == 0)
					count+=1;
			}
		}
		
		safeArea = Math.max(safeArea, count);
	}
	static int[][] simulation(int[][] map) {
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> virusLocation = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 2)
					virusLocation.add(new int[] {i, j});
			}
		}
		
		int[] peek = virusLocation.peek();
		visit[peek[0]][peek[1]] = true;
		
		while(!virusLocation.isEmpty()) {
			int[] poll = virusLocation.poll();
			int curX = poll[0];
			int curY = poll[1];
			map[curX][curY] = 2;
			
			for(int i = 0; i<4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;
				if(visit[nextX][nextY] || map[nextX][nextY] != 0)
					continue;
				
				virusLocation.add(new int[] {nextX, nextY});
				visit[nextX][nextY] = true;
			}
		}
		
		return map;
	}
}