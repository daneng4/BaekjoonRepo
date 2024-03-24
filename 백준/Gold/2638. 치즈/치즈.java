import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		// map == 1 : 치즈, map == 2 : 외부공기, map == 0 : 내부공기
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				int info = Integer.parseInt(st.nextToken());
				map[i][j] = info;
			}
		}
		int result = 0;
		while(true) {
			if(isDeleteAll())
				break;
			result++;
			checkOutSideAir(0,0);
			initVisit();
			deleteCheese();
		}
		
		System.out.println(result);
	}
	// 치즈가 전부 삭제되었는지 확인하는 메서드
	public static boolean isDeleteAll() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 1)
					return false;
			}
		}
		return true;
	}
	// dfs 탐색으로 외부 공기의 위치 파악 메서드
	public static void checkOutSideAir(int x, int y) {
		visit[x][y] = true;
		map[x][y] = 2;
		
		for(int i = 0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
				continue;
			if(map[nextX][nextY] == 1 || visit[nextX][nextY])
				continue;
			
			checkOutSideAir(nextX, nextY);
		}
	}
	// 치즈 삭제 메서드
	public static void deleteCheese() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				// 해당 위치가 치즈이고
				if(map[i][j] == 1) {
					if(isDeleteCheese(i,j))
						q.offer(new int[] {i,j});
				}
				
			}
		}
		
		// 치즈 삭제
		while(!q.isEmpty()) {
			int[] deletePos = q.poll();
			int x = deletePos[0];
			int y = deletePos[1];
			map[x][y] = 0;
		}
				
	}
	// 방문 초기화 메서드
	public static void initVisit() {
		for(int i = 0; i<n; i++) {
			Arrays.fill(visit[i], false);
		}
	}
	// 삭제될 치즈인지 확인하는 메서드
	public static boolean isDeleteCheese(int x, int y) {
		int count = 0;
		for(int i = 0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(map[nextX][nextY] == 2)
				count++;
		}
		
		if(count >= 2)
			return true;
		else
			return false;
	}
}