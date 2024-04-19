
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int test_num = Integer.parseInt(br.readLine());
			Deque<Integer> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int sub = 1;
			while(q.peekLast() > 0) {
				if(sub == 6)
					sub = 1;
				int poll = q.pollFirst();
				q.add(poll-sub);
				sub++;
			}
			q.pollLast();
			q.add(0);
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				sb.append(q.pollFirst() + " ");
			}
			bw.write(String.format("#%d %s\n", test_num, sb.toString()));
			
		} // end of testcase
		bw.flush();
	}
}
