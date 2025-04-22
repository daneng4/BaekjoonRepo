
import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[] visit;
	static int count = 1;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//무방향 그래프 정보 입력
			graph[a][b] = graph[b][a] = 1;
		}
		
		for(int i = 1; i<=n; i++) {
			if(visit[i])
				continue;
			
			// i 노드를 시작으로 연결된 모든 노드 순회
			dfs(i);
			for(int j = 1; j<visit.length; j++) {
				// i 노드를 시작으로 전부 순회했지만 아직 미방문한 노드가 있다면
				// 다른 연결 정보가 있는 것이므로 count를 증가하고 break
				if(!visit[j]) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
	public static void dfs(int node) {
		visit[node] = true;
		
		for(int i = 1; i<graph.length; i++) {
			// 현재 노드와 연결된 노드이며 아직 방문을 안한 노드인 경우
			if(graph[node][i] == 1 && !visit[i])
				dfs(i);
		}
	}
}




