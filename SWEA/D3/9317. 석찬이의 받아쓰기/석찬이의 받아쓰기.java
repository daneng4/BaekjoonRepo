
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int len = Integer.parseInt(br.readLine());
			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();
			
			int answer = len;
			for(int i = 0; i<len; i++) {
				if(a[i] != b[i])
					answer--;
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
}