
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			long n = Long.parseLong(br.readLine());

			long left = 0; long right = 0;
			left = 2*(n-1)*(n-1) + 1;
			right = 2*n*n-1;
			
			bw.write(String.format("#%d %d %d\n", t, left, right));
		} // testcase
		bw.flush();
	}
}