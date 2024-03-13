import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception  {
		final int init = 987654321;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				arr[i][j] = init;
				if(i==j)
					arr[i][j] = 0;
			}
		}
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], v);
		}
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++ ) {
				if(arr[i][j] == init)
					arr[i][j] = 0;
				
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
