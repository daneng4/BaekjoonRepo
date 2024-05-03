
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[n+1];
			
			for(int i = 1; i<=q; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				for(int j = l; j<=r; j++) {
					nums[j] = i;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i<=n; i++) {
				sb.append(nums[i]).append(" ");
			}
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		} // testcase
		bw.flush();
	}
}