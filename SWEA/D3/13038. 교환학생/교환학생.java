
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] c = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<7; i++) {
				int info = Integer.parseInt(st.nextToken());
				c[i] = info;
			}
			
			int answer = Integer.MAX_VALUE;
			for(int i = 0; i<7; i++) {
				if(c[i] == 1) {
					int start = i;
					int count = 0;
					
					while(true) {
						if(c[start % 7] == 1) {
							count++;
						}
						start++;
						
						if(count == n) {
							answer = Math.min(answer, start-i);
							break;
						}
					}
				}
					
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}

}