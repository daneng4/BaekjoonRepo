import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		sb = new StringBuilder();
		
		solve(N, M, 0, 1);
		
		System.out.println(sb);
	}
	
	public static void solve(int N, int M, int depth, int picked) {
		if(depth == M) {
			
			for(int a : arr){
				sb.append(a).append(" ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i = picked; i<=N; i++) {
			arr[depth] = i;
			solve(N, M, depth+1, i);
		}
	}
}