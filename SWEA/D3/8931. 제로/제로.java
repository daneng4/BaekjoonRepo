import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Integer> s = new Stack<>();
			for(int i = 0; i<n; i++) {
				int cost = Integer.parseInt(br.readLine());
				if(cost == 0 && s.size() >= 1) {
					s.pop();
				}
				else
					s.push(cost);
			}
			
			int answer = 0;
			if(!s.isEmpty()) {
				while(!s.isEmpty()) {
					answer += s.pop();
				}
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
}