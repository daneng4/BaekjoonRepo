
import java.io.*;
import java.util.*;
class Main {
	public static String[][] map;
	public static boolean[][] visit;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	static int n,m;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j<str.length; j++) {
				map[i][j] = str[j];
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j].equals("I")) {
					bfs(i,j);
					break;
				}
			}
		}
		if(count > 0)
			System.out.println(count);
		else
			System.out.println("TT");
	}
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i = 0; i<4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				
				if(nextx < 0 || nextx>=n || nexty<0||nexty>=m) {
					continue;
				}
				if(map[nextx][nexty].equals("X") || visit[nextx][nexty]) {
					continue;
				}
				
				if(map[nextx][nexty].equals("P")) {
					count++;
				}
				q.offer(new int[]{nextx,nexty});
				visit[nextx][nexty] = true;
			}
		}
	}
}
