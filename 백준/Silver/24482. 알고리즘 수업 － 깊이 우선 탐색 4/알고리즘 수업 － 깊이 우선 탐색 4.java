import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		map = new ArrayList[n+1];
		dist = new int[n+1];
		visit = new boolean[n+1];

		Arrays.fill(dist, -1);

		for(int i = 1; i<=n; i++){
			map[i] = new ArrayList<>();
		}

		for(int i = 0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}

		for(int i = 1; i<=n; i++){
			map[i].sort(Collections.reverseOrder());
		}

		dfs(r, 0);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++)
			sb.append(dist[i] + "\n");

		System.out.println(sb);
	}
	public static void dfs(int node, int depth){
		if(visit[node]) return;

		visit[node] = true;
		dist[node] = depth;
		for(int next : map[node]){
			dfs(next, depth + 1);
		}
	}
}
