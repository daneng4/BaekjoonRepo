import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int n, m;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int year = 0;
	static Queue<Info> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(!checkEnd()) {
			// 빙산 녹는량 확인
			for(int i = 1; i<n-1; i++) {
				for(int j = 1; j<m-1; j++) {
					if(map[i][j] > 0)
						melt(i,j);
				}
			}
			// 녹이기
			while(!q.isEmpty()) {
				Info poll = q.poll();
				map[poll.x][poll.y] -= poll.sub;
				if(map[poll.x][poll.y] < 0)
					map[poll.x][poll.y] = 0;
			}
		}
		
		System.out.println(year);
	}
	public static boolean checkEnd() {
		// 종료조건
		// 2덩어리로 나누어지지않고 모든 빙산이 녹을 때
		if(checkMelt()) {
			year = 0;
			return true;
		}
		
		// 빙산이 2덩어리 이상으로 나누어졌는지 확인
		if(checkDivide()) {
			return true;
		}
		
		year+=1;
		return false;
	}
	public static boolean checkMelt() {
		for(int i = 1; i<n-1; i++) {
			for(int j = 1; j<m-1; j++) {
				if(map[i][j] > 0)
					return false;
			}
		}
		return true;
	}
	public static boolean checkDivide() {
		int count = 0;
		for(int i = 1; i<n-1; i++) {
			for(int j = 1; j<m-1; j++) {
				if(visit[i][j] || map[i][j] == 0) continue;
				bfs(i,j);
				count++;
			}
		}
		
		// 방문 초기화
		for(boolean[] v : visit) {
			Arrays.fill(v, false);
		}
		
		// count >= 2이면 true 반환
		if(count >= 2)
			return true;
		return false;
	}
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int nowx = poll[0];
			int nowy = poll[1];
			
			for(int i = 0; i<4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if(visit[nextx][nexty]) continue;
				if(map[nextx][nexty] > 0) {
					q.add(new int[] {nextx, nexty});
					visit[nextx][nexty] = true;
				}
			}
		}

	}
	public static void melt(int x, int y) {
		// 현재 좌표의 상하좌우를 확인해서 0의 개수만큼 녹인다.
		int count = 0;
		for(int i = 0; i<4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			if(map[nextx][nexty] == 0)
				count++;
		}
		
		q.add(new Info(x,y,count));
	}
}
class Info{
	int x;
	int y;
	int sub;
	Info(int x, int y, int sub){
		this.x = x; this.y = y; this.sub = sub;
	}
}