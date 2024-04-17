
import java.io.*;
import java.util.*;

class Solution {
	static boolean[][] visit;
	static int n;
	static int[] num;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			num = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				sum += num[i];
			}

			visit = new boolean[n + 1][sum + 1];

			dfs(0, 0);
			int ans = 0;
			for (int i = 0; i <= sum; i++) {
				if (visit[n][i])
					ans++;
			}
			bw.write(String.format("#%d %d\n", test_case, ans));
		} // end of testcase
		bw.flush();
	}

	public static void dfs(int sum, int idx) {
		if (visit[idx][sum])
			return;
		visit[idx][sum] = true;
		if (idx == n)
			return;
		// 이 수를 선택
		dfs(sum + num[idx], idx + 1);
		// 선택 x
		dfs(sum, idx + 1);
	}
}