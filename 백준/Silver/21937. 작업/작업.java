import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		visit = new boolean[N+1];
		answer = -1;
		
		for(int i = 1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			map[B].add(A);
		}
		
		int X = Integer.parseInt(br.readLine());
		dfs(X);
		
		System.out.println(answer);
	}
	public static void dfs(int X) {
		answer++;
		visit[X] = true;
//		System.out.println(X);
		for(int next : map[X]) {
			if(visit[next]) continue;
		
			dfs(next);
		}
	}
}
