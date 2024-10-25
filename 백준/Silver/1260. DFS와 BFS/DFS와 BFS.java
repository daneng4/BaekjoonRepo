
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visit;
	static List<Integer>[] map;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i = 1; i<=n; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		
		for(int i = 1; i<map.length; i++) {
			Collections.sort(map[i]);
		}
		
		dfs(v);
		sb.append("\n");
		Arrays.fill(visit, false);
		bfs(v);
		
		System.out.println(sb.toString());
		
    }
	public static void dfs(int node) {
		if(visit[node])
			return;
		
		visit[node] = true;
		sb.append(node + " ");
		
		for(int next: map[node]) {
			if(!visit[next])
				dfs(next);
		}
	}
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visit[node] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			sb.append(poll + " ");
			
			for(int next : map[poll]) {
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
				}
			}
		}
		
	}
}
