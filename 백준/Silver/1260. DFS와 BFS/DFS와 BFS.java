
import java.util.*;
import java.io.*;

public class Main {

	static int n, m, v;
	static boolean[] visited;
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		
		sb.append("\n");
		visited = new boolean[n+1];
		bfs(v);
		
		System.out.println(sb.toString());
	}
	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		
		if(start == graph.length) return;
		
		for(int i = 1; i<graph.length; i++) {
			if (graph[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int nodeindex = q.poll();
			sb.append(nodeindex + " ");
			for(int i = 1; i<graph.length; i++) {
				if(!visited[i] && graph[nodeindex][i] == 1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
	}
}


