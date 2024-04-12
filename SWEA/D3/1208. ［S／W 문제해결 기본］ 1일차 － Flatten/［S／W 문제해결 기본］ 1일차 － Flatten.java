
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = 10;
		
		for(int t = 1; t<=testCase; t++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] h = new int[100];
			for(int i = 0; i<100; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<dump; i++) {
				Arrays.sort(h);
				h[99]--;
				h[0]++;
			}
			
            Arrays.sort(h);
			int answer = h[99] - h[0];
			
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
	}

}