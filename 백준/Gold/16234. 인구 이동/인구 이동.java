import java.io.*;
import java.util.*;

public class Main {

	public static int[][] map;
	public static boolean[][] visit;
	public static int n;
	public static int l, r;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean isUnion;
	public static void main(String[] args) throws Exception  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		int count = 0;

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			visit = new boolean[n][n];
			isUnion = false;

			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(visit[i][j]) continue;
					findUnion(i,j);
				}
			}
			if(!isUnion) {
				break;
			}
			count++;
		}
		System.out.println(count);

	}
	public static void findUnion(int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> union = new LinkedList<>();
		q.offer(new int[] {startX, startY});
		visit[startX][startY] = true;
		union.offer(new int[] {startX,startY});
		int sum = 0;
		sum = sum + map[startX][startY];

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			for(int i = 0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >=n || nextY >=n) {
					continue;
				}
				if(visit[nextX][nextY])
					continue;
				int dif = Math.abs(map[nextX][nextY] - map[nowX][nowY]);
				if(dif>=l && dif<=r) {
					isUnion = true;
					union.offer(new int[] {nextX,nextY});
					q.offer(new int[] {nextX,nextY});
					sum = sum + map[nextX][nextY];
					visit[nextX][nextY] = true;
				}
			}
		}
		popRelocation(union, sum);
	}

	public static void popRelocation(Queue<int[]> union, int sum) {
		int size = union.size();
		int pop = sum/size;
		for(int i = 0; i<size; i++) {
			int[] loc = union.poll();
			int locX = loc[0];
			int locY = loc[1];
			map[locX][locY] = pop;
		}
	}

}
