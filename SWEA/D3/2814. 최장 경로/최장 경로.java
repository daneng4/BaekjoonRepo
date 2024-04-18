import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 1) {
				bw.write(String.format("#%d %d\n", t, 1));
				continue;
			}
			
			list = new ArrayList[n+1];
			visit = new boolean[n+1];
			for(int i = 1; i<=n; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			answer = 0;
			for(int i = 1; i<=n; i++) {
				dfs(i, 0);
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		}// end of tc
		bw.flush();
	}
	public static void dfs(int start, int depth) {
		answer = Math.max(answer, depth);
		
		for(int next : list[start]) {
			if(visit[next])
				continue;
			visit[next] = true;
			dfs(next, depth+1);
			visit[next] = false;
		}
		
	}
}
