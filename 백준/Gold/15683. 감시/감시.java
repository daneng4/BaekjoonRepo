import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<CCTV> list;
	static ArrayList<Integer> direction;
	static int[][] copy;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	static int M;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		direction = new ArrayList<>();
		answer = Integer.MAX_VALUE;

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5){
					list.add(new CCTV(i,j,map[i][j]));
				}
			}
		}

		// CCTV를 회전시켜 CCTV 별 감시 영역의 최대를 구하는 함수
		chooseDirectionPerCCTV(0);

		System.out.println(answer);
	}
	public static void chooseDirectionPerCCTV(int depth){
		if(depth == list.size()){
			copy = new int[N][M];
			for(int i = 0; i<N; i++){
				copy[i] = map[i].clone();
			}

			for(int i = 0; i<list.size(); i++){
				checkMonitoringArea(list.get(i), direction.get(i));
			}

			getBlindSpot();
			return;
		}

		for(int i = 0; i<4; i++){
			direction.add(i);
			chooseDirectionPerCCTV(depth+1);
			direction.remove(direction.size() - 1);
		}
	}

	public static void checkMonitoringArea(CCTV cctv, int d){
		int model = cctv.model;

		if(model == 1){
			if(d == 0) monitoring(cctv, 0);
			else if(d == 1) monitoring(cctv, 1);
			else if(d == 2) monitoring(cctv, 2);
			else if(d == 3) monitoring(cctv, 3);
		} else if(model == 2){
			if(d == 0 || d == 2){
				monitoring(cctv, 0);
				monitoring(cctv, 2);
			} else{
				monitoring(cctv, 1);
				monitoring(cctv, 3);
			}
		} else if(model == 3){
			if(d == 0) {
				monitoring(cctv, 0);
				monitoring(cctv, 1);
			} else if(d == 1){
				monitoring(cctv, 1);
				monitoring(cctv, 2);
			} else if(d == 2){
				monitoring(cctv, 2);
				monitoring(cctv, 3);
			} else if(d == 3){
				monitoring(cctv, 3);
				monitoring(cctv, 0);
			}
		} else if(model == 4){
			if(d == 0){
				monitoring(cctv, 0);
				monitoring(cctv, 1);
				monitoring(cctv, 2);
			} else if(d == 1){
				monitoring(cctv, 1);
				monitoring(cctv, 2);
				monitoring(cctv, 3);
			} else if(d == 2){
				monitoring(cctv, 2);
				monitoring(cctv, 3);
				monitoring(cctv, 0);
			} else if(d == 3){
				monitoring(cctv, 3);
				monitoring(cctv, 0);
				monitoring(cctv, 1);
			}
		} else if(model == 5){
			monitoring(cctv, 0);
			monitoring(cctv, 1);
			monitoring(cctv, 2);
			monitoring(cctv, 3);
		}

	}

	// bfs
	public static void monitoring(CCTV cctv, int d){
		Queue<CCTV> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];

		q.add(cctv);
		visited[cctv.x][cctv.y] = true;

		while(!q.isEmpty()){
			CCTV poll = q.poll();
			int nx = poll.x + dx[d];
			int ny = poll.y + dy[d];

			if(nx < 0 || nx >= N || ny < 0 || ny >= M || copy[nx][ny] == 6)
				break;

			if(copy[nx][ny] == 0){
				copy[nx][ny] = -1;
				q.add(new CCTV(nx, ny, cctv.model));
			} else{
				q.add(new CCTV(nx, ny, cctv.model));
			}
		}
	}

	public static void getBlindSpot(){
		int count = 0;
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(copy[i][j] == 0)
					count++;
			}
		}

		answer = Math.min(answer, count);
	}

	public static class CCTV {
		int x;
		int y;
		int model;
		public CCTV(int x, int y, int model){
			this.x = x; this.y = y; this.model = model;
		}
	}
}
