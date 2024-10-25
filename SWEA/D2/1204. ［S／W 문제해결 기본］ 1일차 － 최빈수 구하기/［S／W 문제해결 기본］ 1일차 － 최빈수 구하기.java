import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ts = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 1; i<=ts; i++) {
			int tcn = Integer.parseInt(br.readLine());
			int[] num = new int[101];
			st = new StringTokenizer(br.readLine());
			int maxcnt = 0;
			int answer = 0;
			
			for(int j = 0; j<1000; j++) {
				int score = Integer.parseInt(st.nextToken());
				num[score]++;
				maxcnt = Math.max(maxcnt, num[score]);
			}
			
			for(int j = 1; j<num.length; j++) {
				if(num[j] == maxcnt) {
					answer = j;
				}
			}
			
			bw.write(String.format("#%d %d\n", tcn, answer));
		}
		
		bw.flush();
		bw.close();
	}	
}
