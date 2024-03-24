
import java.io.*;
import java.util.*;

public class Main {
	static int[] num, print;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		print = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		dfs(0, 0);
		
		System.out.println(sb.toString());
		
	}
	public static void dfs(int start, int depth) {
		if(depth == m) {
			for(int i = 0; i<m; i++) {
				sb.append(print[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = -1;
		for(int i = start; i<n; i++) {
			int now = num[i];
			if(before != now) {
				before = now;
				print[depth] = num[i];
				dfs(i, depth+1);
			}
		}
	}

}