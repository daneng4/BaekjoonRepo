
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,r;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<r; k++) {
			int t = Math.min(n, m) / 2;
			for(int i = 0; i < t; i++) {
				turn(1+i, 1+i, n-i, m-i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void turn(int x, int y, int n, int m) {
		// 시작은 가장 왼쪽 위에 있는 배열 부터, 위 <- 오른쪽 <- 아래 <- 왼쪽
		int temp = map[x][y];
		
		// 위쪽 이동
		for(int i = 0; i<m-y; i++) {
			map[x][y+i] = map[x][y+i+1];
		}
		// 오른쪽 이동
		for(int i = 0; i<n-x; i++) {
			map[x+i][m] = map[x+i+1][m];
		}
		// 아래쪽 이동
		for(int i = 0; i<m-y; i++) {
			map[n][m-i] = map[n][m-i-1];
		}
		// 왼쪽 이동
		for(int i = 0; i<n-x-1; i++) {
			map[n-i][y] = map[n-i-1][y];
		}
		map[x+1][y] = temp;
	}
}