import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] node;
	static int[] visit;
	static int count = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		node = new ArrayList[n+1];
		visit = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			node[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a].add(b);
			node[b].add(a);
		}
		
		for(int i = 1; i<node.length; i++) {
			Collections.sort(node[i]);
		}
	
		dfs(r);
		
		for(int i = 1; i<visit.length; i++) {
			sb.append(visit[i]).append("\n");
		}
	
		System.out.println(sb);
	}
	public static void dfs(int cur) {
		visit[cur] = count;
		
		for(int i = 0; i<node[cur].size(); i++) {
			int next = node[cur].get(i);
			
			if(visit[next] == 0) {
				count += 1;
				dfs(next);
			}
			
		}
	}
}
