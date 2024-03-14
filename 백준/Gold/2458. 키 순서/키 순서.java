
import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1][n+1];
		
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			visit[a][b] = true;
		}
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(visit[i][k] && visit[k][j])
						visit[i][j] = true;
				}
			}
		}
		
		int[] count = new int[n+1];
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(visit[i][j] || visit[j][i])
					count[i]++;
			}
		}
		int result = 0;
		for(int i = 1; i<=n; i++) {
			if(count[i] == n-1)
				result++;
		}
		System.out.println(result);
	}	
}

