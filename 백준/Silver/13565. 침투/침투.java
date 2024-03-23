import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static ArrayList<int[]> outer, inner;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		outer = new ArrayList<>();
		inner = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			String[] mapInfo = br.readLine().split("");
			for(int j = 0; j<mapInfo.length; j++) {
				
				int info = Integer.parseInt(mapInfo[j]);
				if(i == 0 && info == 0)
					outer.add(new int[] {i,j});
				if(i == n-1 && info == 0)
					inner.add(new int[] {i,j});
				
				map[i][j] = info;
			}
		}
		
		boolean isPercolate = false;
		for(int[] pos : outer) {
			visit = new boolean[n][m];
			bfs(pos);
			isPercolate = checkPercolate();
			
			if(isPercolate) {
				System.out.println("YES");
				break;
			}
		}
		
		if(!isPercolate) 
			System.out.println("NO");
	}
	public static void bfs(int[] outer) {
		Queue<int[]> q = new LinkedList<>();
		visit[outer[0]][outer[1]] = true;
		q.offer(outer);
		
		while(!q.isEmpty()) {
			int[] curPos = q.poll();
			int x = curPos[0];
			int y = curPos[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX<0 || nextY<0 || nextX >= n || nextY >= m) 
					continue;
				
				if(visit[nextX][nextY] || map[nextX][nextY] == 1)
					continue;
				
				q.offer(new int[] {nextX, nextY});
				visit[nextX][nextY] = true;
			}
			
		}
		
	}
	public static boolean checkPercolate() {
		for(int[] innerElement : inner) {
			int x = innerElement[0];
			int y = innerElement[1];
			
			if(visit[x][y])
				return true;
		}
		return false;
		
	}
}