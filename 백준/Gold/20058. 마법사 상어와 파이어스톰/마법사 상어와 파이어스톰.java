import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	static boolean[][] ice;
	static boolean[][] visit;
	static int l, size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2,n);
		map = new int[size][size];

		for(int i = 0; i<size; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<size; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while(q -- > 0){
			ice = new boolean[size][size];
			l = Integer.parseInt(st.nextToken());

			map = divide(l);
			map = melt();
		}

		int totalIce = 0;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				totalIce += map[i][j];
			}
		}
		System.out.println(totalIce);

		int maxIce = 0;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				if(map[i][j] != 0){
					maxIce = Math.max(maxIce, bfs(i,j));
				}
			}
		}

		System.out.println(maxIce);
	}
	public static int[][] divide(int l){
		int[][] tmp = new int[size][size];
		l = (int) Math.pow(2, l);
		for (int i = 0; i < size; i += l) {
			for (int j = 0; j < size; j += l) {
				spin(i, j, l, tmp);
			}
		}
		return tmp;
	}
	public static void spin(int x, int y, int l, int[][] tmp){
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				tmp[x + i][y + j] = map[x + l - 1 - j][y + i];
			}
		}
	}
	public static int[][] melt(){
		int[][] tmp = new int[size][size];
		for (int i = 0; i < size; i++) {
			tmp[i] = Arrays.copyOf(map[i], size);
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
						if (map[nx][ny] > 0) {
							cnt++;
						}
					}
				}
				if (cnt < 3)
					tmp[i][j]--;
			}
		}
		return tmp;
	}
	public static int bfs(int x, int y){
		visit = new boolean[size][size];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;

		int result = 0;
		while(!q.isEmpty()){
			int[] poll = q.poll();
			result += 1;

			for(int i = 0; i<4; i++){
				int nextx = poll[0] + dx[i];
				int nexty = poll[1] + dy[i];

				if(nextx < 0 || nextx >= size || nexty < 0 || nexty >= size)
					continue;
				if(visit[nextx][nexty] || map[nextx][nexty] == 0) continue;

				q.add(new int[] {nextx, nexty});
				visit[nextx][nexty] = true;
			}
		}

		return result;
	}
}
