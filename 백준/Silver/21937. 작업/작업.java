import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		visit = new boolean[n+1];

		for(int i = 1; i<=n; i++)
			map[i] = new ArrayList<>();

		for(int i = 0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[b].add(a);
		}

		int start = Integer.parseInt(br.readLine());
		answer = 0;
		dfs(start);
		System.out.println(answer);
	}
	public static void dfs(int node){
		visit[node] = true;
		for(int next : map[node]){
			if(visit[next]) continue;
			answer++;
			dfs(next);
		}
	}
}
