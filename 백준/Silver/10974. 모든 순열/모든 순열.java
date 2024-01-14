
import java.io.*;
import java.util.*;
class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visit = new boolean[n+1];
		
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int count) {		
		if(count == n) {
			for(int i = 0; i<n; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<=n; i++) {
			if(visit[i])
				continue;
			arr[count] = i;
			visit[i] = true;
			dfs(count+1);
			visit[i] = false;
		}
		
	}
}
