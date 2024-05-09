import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			int users = (int)Math.pow(2, n); // 참가자 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<int[]> play = new LinkedList<>();
			for(int i = 0; i<users/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				play.add(new int[] {a,b});
			}
			
			int answer = 0;
			while(play.size() != 1) {
				int[] match1 = play.poll();
				int[] match2 = play.poll();
				
				answer += Math.abs(match1[0] - match1[1]);
				int match1winner = Math.max(match1[0], match1[1]);
				
				answer += Math.abs(match2[0] - match2[1]);
				int match2winner = Math.max(match2[0], match2[1]);
				
				play.add(new int[] {match1winner, match2winner});
			}
			
			int[] finalmatch = play.poll();
			answer += Math.abs(finalmatch[0] - finalmatch[1]);
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
			
	}
}
