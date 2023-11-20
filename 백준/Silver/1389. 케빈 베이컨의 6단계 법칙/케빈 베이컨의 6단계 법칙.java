
import java.io.*;
import java.util.*;
class Main {

	static int[][] relation;
	static int n,m;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		relation = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				relation[i][j] = INF;
				
				if(i == j)
					relation[i][j] = 0;
			}
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a][b] = relation[b][a] = 1;
		}
		
		//플로이드 워셜 알고리즘
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(relation[i][j] > relation[i][k] + relation[k][j])
						relation[i][j] = relation[i][k] + relation[k][j];
				}
			}
		}
		
		int result = INF;
		int idx = -1;
		
		for(int i = 1; i<=n; i++) {
			int total = 0;
			for(int j = 1; j<=n; j++) {
				total += relation[i][j];
			}
			if(result > total) {
				result = total;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
