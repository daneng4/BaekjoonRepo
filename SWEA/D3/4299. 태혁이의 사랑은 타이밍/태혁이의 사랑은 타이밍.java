
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int pepero = (24 * 11 * 60) + (11 * 60) + 11;
			int cur = (24 * 60 * D) + (60 * H) + M;
			
			if(pepero > cur)
				bw.write(String.format("#%d -1\n", t));
			else
				bw.write(String.format("#%d %d\n", t, cur - pepero));
			
		} // testcase
		bw.flush();
	}
}