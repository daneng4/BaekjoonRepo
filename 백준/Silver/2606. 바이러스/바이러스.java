import java.util.*;
import java.io.*;

public class Main {

	static int[][] graph;
	static boolean[] visited;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i< m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		
		System.out.println(bfs(1, graph, visited));
		
	}
	public static Integer bfs(int start, int[][] graph, boolean[] visited) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		
		visited[start] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int nodeindex = q.poll();
			count++;
			for(int i = 1; i<graph.length; i++) {
				if(!visited[i] && graph[nodeindex][i] == 1) { 
					// graph[nodeindex][i] 는 현재 nodeindex와 인접한 노드들을 나타냄
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		
		return count-1; // 1은 포함하지 않고 그 외 노드만 count
	}
}


