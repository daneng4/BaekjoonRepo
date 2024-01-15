
import java.io.*;
import java.util.*;
class Main {
	static int[] up;
	static int k,n;
	static boolean[] visit;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 날짜 수
		k = Integer.parseInt(st.nextToken()); // 근손실
		up = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			up[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 500);
		System.out.println(result);
	}
	public static void dfs(int day, int cur) {
		if(cur<500) {
			return;
		}
		if(day == n) {
			result++;
			return;
		}

		for(int i = 0; i<n; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(day+1, cur-k+up[i]);
			visit[i] = false;
		}
		
	}
}
