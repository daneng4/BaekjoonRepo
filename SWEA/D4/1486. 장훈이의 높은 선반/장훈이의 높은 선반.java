
import java.io.*;
import java.util.*;

class Solution {
	static int n;
	static int height;
	static int[] h;
	static int answer;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			h = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = Integer.MAX_VALUE;
			solve(0, 0, 0);
			bw.write(String.format("#%d %d\n", test_case, answer));
		} // end of testcase
		bw.flush();
	}
	public static void solve(int idx, int depth, int sum) {
		if(depth == n) {
			// 만약 쌓은 탑이 선반 높이보다 크거나 같아진 경우 차의 최소 갱신
			if(sum >= height) {
				answer = Math.min(answer, sum-height);
			}
			return;
		}
		
		// 해당 직원 탑쌓기
		solve(idx+1, depth+1, sum+h[idx]);
		// 탑 안 쌓기
		solve(idx+1, depth+1, sum);
	}
}
