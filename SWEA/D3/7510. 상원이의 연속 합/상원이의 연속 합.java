
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for(int i = 1; i<=n; i++) {
				int sum = 0;
				
				for(int j = i; j<=n; j++) {
					sum += j;
					
					if(sum == n) {
						answer++;
						break;
					}else if(sum > n) {
						break;
					}
				}
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
}