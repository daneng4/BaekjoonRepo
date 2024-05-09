import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			visit = new boolean[n+1];
			for(int i = 1; i<=n; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) {
					int b = Integer.parseInt(st.nextToken());
					list[a].add(b);
					list[b].add(a);
				}else
					list[a].add(a);
			}
			int answer = 0;
			for(int i = 1; i<=n; i++) {
				if(visit[i])
					continue;
				dfs(i);
				answer++;
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
			
	}
	public static void dfs(int node) {
		if(visit[node])
			return;
		visit[node] = true;
		
		for(int next : list[node]) {
			dfs(next);
		}
	}
}
