import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visit;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		map = new ArrayList[n+1];

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
		
		int answer = 0;
		for(int i = 1; i<=n; i++) {
			if(!visit[i]) {
				dfs(i);
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
	static void dfs(int start) {
		if(visit[start])
			return;
		visit[start] = true;
		for(int next : map[start]) {
			dfs(next);
		}
	}
}