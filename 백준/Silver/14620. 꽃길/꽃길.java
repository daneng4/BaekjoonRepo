
import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int result = Integer.MAX_VALUE;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		StringTokenizer st;
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0);
		System.out.println(result);
	}
	public static void find(int count, int sum) {
		if(count == 3) {
			result = Math.min(sum, result);
			return;
		}
		
		for(int i = 2; i<n; i++) {
			for(int j = 2; j<n; j++) {
				// i,j 가 2,2 부터 n-1,n-1까지 탐색하므로
				// map을 벗어나는 것에 대한 예외처리는 생략가능하다.
				// 씨를 뿌릴 좌표가 이미 visit인지 확인한다
				if(visit[i][j])
					continue;
				// 상하좌우의 좌표가 이미 visit인지 확인한다
				if(isVisited(i,j))
					continue;
				
				visit[i][j] = true;
				find(count+1, sum+getSum(i,j));
				
				initVisit(i,j);
				visit[i][j] = false;
			}
		}
		
	}
	public static boolean isVisited(int x, int y) {
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(visit[nx][ny])
				return true;
		}
		return false;
	}
	public static int getSum(int x, int y) {
		int curSum = map[x][y];
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			visit[nx][ny] = true;
			curSum += map[nx][ny];
		}
		return curSum;
	}
	public static void initVisit(int x, int y) {
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			visit[nx][ny] = false;
		}
	}
}
