
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			char[] info = br.readLine().toCharArray();
			int[] s = new int[14];
			int[] d = new int[14];
			int[] h = new int[14];
			int[] c = new int[14];
			
			
			boolean isError = false;
			
			for(int i = 0; i<info.length; i+=3) {
				StringBuilder sb = new StringBuilder();
				char shape = info[i];
				sb.append(info[i+1]).append(info[i+2]);
				int num = Integer.parseInt(sb.toString());
				
				if(shape == 'S') {
					if(s[num] == 1) {
						isError = true;
						break;
					}
					s[num]++;
				}else if(shape == 'D') {
					if(d[num] == 1) {
						isError = true;
						break;
					}
					d[num]++;
				}else if(shape == 'H') {
					if(h[num] == 1) {
						isError = true;
						break;
					}
					h[num]++;
				}else {
					if(c[num] == 1) {
						isError = true;
						break;
					}
					c[num]++;
				}
			}
			
			if(isError) {
				bw.write(String.format("#%d ERROR\n", t));
			}else {
				int scount = 13; int dcount = 13; int hcount = 13; int ccount = 13;
				for(int i = 1; i<=13; i++) {
					scount -= s[i];
					dcount -= d[i];
					hcount -= h[i];
					ccount -= c[i];
				}
				bw.write(String.format("#%d %d %d %d %d\n", t, scount, dcount, hcount, ccount));
			}
			
		} // testcase
		bw.flush();
	}
}