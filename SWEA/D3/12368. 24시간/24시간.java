
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int pass = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i<=pass; i++) {
				time += 1;
				if(time == 24)
					time = 0;
			}
			
			bw.write(String.format("#%d %d\n", t, time));
		} // testcase
		bw.flush();
	}
}