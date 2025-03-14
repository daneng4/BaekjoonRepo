import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<PriorityQueue<Integer>> list;
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		visit = new boolean[N+1];
		arr = new int[N+1];

		for(int i = 0; i<=N; i++) {
			list.add(new PriorityQueue<>());
		}
	
		
		Arrays.fill(arr, -1);
		
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(R, 0);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	static void dfs(int R, int count) {
		visit[R] = true;
		arr[R] = count;
		
		while(!list.get(R).isEmpty()) {
			int next = list.get(R).poll();
			if(visit[next])
				continue;
			dfs(next, count + 1);
		}
	}
}