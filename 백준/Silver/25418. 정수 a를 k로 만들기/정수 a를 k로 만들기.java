import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
//		bfs(A,K);
		greedy(A,K);
//		dp(A,K);
	}
	static void bfs(int A, int K) {
		int max = 1000001;
		Queue<int[]> q = new LinkedList<>();
		boolean[] visit = new boolean[max];
		q.add(new int[] {A, 0});
		visit[A] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int num = now[0];
			int count = now[1];
			
			if(num == K) {
				System.out.println(count);
				break;
			}
			
			if(num + 1 < max && !visit[num + 1]) {
				q.add(new int[] {num + 1, count + 1});
				visit[num + 1] = true;				
			}
			
			if(num * 2 < max && !visit[num * 2]) {
				q.add(new int[] {num * 2, count + 1});
				visit[num * 2] = true;
			}
				
		}
	}
	static void greedy(int A, int K) {
		int count = 0;
		while(true) {
			if(K == A) {
				System.out.println(count);
				break;
			}
			
			if(K % 2 == 0 && K / 2 >= A) {
				K = K / 2;
				count += 1;
			}else {
				K = K - 1;
				count += 1;
			}
		}
	}
	static void dp(int A, int K) {
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[A] = 0;
		for(int i = A + 1; i<=K; i++) {
			dp[i] = dp[i-1];
			if(i % 2 == 0 && dp[i/2] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
	}
}