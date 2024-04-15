import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] num1 = new int[n];
			int[] num2 = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				num1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m; i++) {
				num2[i] = Integer.parseInt(st.nextToken());
			}
			
			int tryCount = Math.abs(n - m) + 1;
			int answer = 0;
			
			if(n < m) {
				for(int i = 0; i<tryCount; i++) {
					int sum = 0;
					for(int j = 0; j<n; j++) {
						sum += num1[j] * num2[j+i];
					}
					answer = Math.max(sum,  answer);
				}
			}else {
				for(int i = 0; i<tryCount; i++) {
					int sum = 0;
					for(int j = 0; j<m; j++) {
						sum+= num2[j] * num1[j+i];
					}
					answer = Math.max(sum, answer);
				}
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
			
	}
}
