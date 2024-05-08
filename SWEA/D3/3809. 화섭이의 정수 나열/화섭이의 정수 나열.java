import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			String nums = "";
			int count = 0;
			
			while(true) {
				if(count == n)
					break;
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					String num = st.nextToken();
					nums = nums.concat(num);
					count++;
				}
			}
			
			int answer;
			for(int i = 0; ; i++) {
				if(nums.contains(String.valueOf(i)))
					continue;
				else{
					answer = i;
					break;
				}
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
}