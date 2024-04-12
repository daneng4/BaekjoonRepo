
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			
			for(int i = 0; i<n; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j<str.length; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			if(n == 1) {
				bw.write(String.format("#%d %d\n", t, map[0][0]));
				continue;
			}
			
			int mid = n/2;
			int start = mid; int end = mid;
			int sum = 0;
			
			for(int i = 0; i<n; i++) {
				for(int j = start; j<=end; j++) {
					sum += map[i][j];
				}
				if(i < mid) {
					start = start-1;
					end = end+1;
				}else {
					start = start+1;
					end = end-1;
				}
			}

			bw.write(String.format("#%d %d\n", t, sum));
		} // testcase
		bw.flush();
	}
}
