
import java.util.*;
import java.io.*;

public class Main {

	static int[][] graph;
	static boolean[] visited;
	static int result = -1;
	static int n, p1, p2, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());  // 전체사람 수 n
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken()); // 촌수 계산해야하는사람1
		p2 = Integer.parseInt(st.nextToken()); // 사람2
		m = Integer.parseInt(br.readLine()); // 부모자식 관계개수 m
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(p2, 0);
		System.out.println(result);
	}
	private static void dfs(int start, int count) {
		if (start == p1) {
			result = count;
			return; 
		}
			
		visited[start] = true;
		for(int i = 1; i<n; i++) {
			if(!visited[i] && graph[start][i] == 1) {
				dfs(i, count+1);
			}			
		}
	}
}


