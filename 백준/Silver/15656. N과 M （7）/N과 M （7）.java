
import java.io.*;
import java.util.*;

public class Main {

	private static int[] arr;
	private static boolean[] visit;
	private static int n,m;
	private static int[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		arr = new int[m];
		visit = new boolean[n];
		dfs(n,m,0);
		System.out.println(sb);
		
	}
	private static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int value : arr) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[depth] = list[i];
			dfs(n, m, depth+1);
		}
	}
	
}
