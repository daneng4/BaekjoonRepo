import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] way;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visit;
	static int N;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int problemCount = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			N = Integer.parseInt(br.readLine());

			if(N == 0)
				break;

			map = new int[N][N];
			way = new int[N][N];
			visit = new boolean[N][N];
			for(int i = 0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i<N; i++){
				Arrays.fill(way[i], 987654321);
			}

			int result = find(0,0);
			sb.append("Problem ").append(problemCount).append(": ").append(result).append("\n");
			problemCount++;
		}

		System.out.println(sb);
	}
	public static int find(int sx, int sy){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(sx, sy, map[sx][sy]));
		visit[sx][sy] = true;
		way[sx][sy] = map[sx][sy];

		while(!pq.isEmpty()){
			Node now = pq.poll();

			for(int i = 0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >= N){
					continue;
				}

				if(visit[nx][ny])
					continue;

				way[nx][ny] = Math.min(now.cost + map[nx][ny], way[nx][ny]);
				pq.add(new Node(nx, ny, way[nx][ny]));
				visit[nx][ny] = true;
			}
		}

		return way[N-1][N-1];
	}
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public int compareTo(Node n){
			return this.cost - n.cost;
		}
	}
}
