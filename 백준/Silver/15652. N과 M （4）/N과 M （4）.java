
import java.io.*;
import java.util.*;

public class Main {

	private static int[] arr;
	private static boolean[] visit;
	private static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visit = new boolean[n];
		dfs(0,0);
		System.out.println(sb);
		
	}
	private static void dfs(int start, int depth) {
		if(depth == m) {
			for(int value : arr) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<n; i++) {
			arr[depth] = i+1;
			dfs(i, depth+1);
		}
	}
	
}
