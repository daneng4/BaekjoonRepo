
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] candy = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				candy[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(candy);
			
			int answer = Integer.MAX_VALUE;
			// 슬라이딩 도어
			int start = 0; int end = start+m-1;
			while(end != n) {
				answer = Math.min(answer, candy[end] - candy[start]);
				start++;
				end++;
			}
			
			bw.write(String.format("#%d %d\n", test_case, answer));
		} // end of testcase
		bw.flush();
	}

}
