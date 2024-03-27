
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int[][] map;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 파티장 크기
		m = Integer.parseInt(st.nextToken()); // 손님 수
		map = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		algo();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 손님 위치
			int b = Integer.parseInt(st.nextToken()); // 다음 파티장
			int c = Integer.parseInt(st.nextToken()); // 걸리는 시간
			
			if(map[a][b] <= c)
				sb.append("Enjoy other party").append("\n");
			else
				sb.append("Stay here").append("\n");
		}
		System.out.println(sb);
	}
	public static void algo() {
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
	}
}