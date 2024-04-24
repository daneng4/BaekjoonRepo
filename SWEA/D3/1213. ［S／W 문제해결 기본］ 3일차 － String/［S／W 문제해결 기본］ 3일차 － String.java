
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int testNumber = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			int answer = 0;
			for(int i = 0; i<str.length(); i++) {
				if(str.startsWith(target, i)) {
					answer++;
				}
			}
			bw.write(String.format("#%d %d\n", testNumber, answer));
		} // end of testcase
		bw.flush();
	}
}
