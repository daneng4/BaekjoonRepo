import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		visit = new boolean[N+1];
		sb = new StringBuilder();
		
		solve(1);
		
		System.out.println(sb);
	}
	
	public static void solve(int depth) {
		if(depth == M+1) {
			
			for(int i = 1; i<=M; i++){
				sb.append(arr[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(visit[i]) continue;
			
			arr[depth] = i;
			visit[i] = true;
			solve(depth+1);
			visit[i] = false;
		}
	}
}