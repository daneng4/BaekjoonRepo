import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 999999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];

		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(i == j) continue;
				map[i][j] = INF;
			}
		}

		for(int i = 0; i<m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[a][b] = Math.min(map[a][b], cost);
		}

		for(int k = 1; k<=n; k++){
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=n; j++){
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(map[i][j] == INF) sb.append(0 + " ");
				else sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
