import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				
				if(op == 1) {
					int num = Integer.parseInt(st.nextToken());
					pq.add(num);
				}else {
					if(!pq.isEmpty()) {
						sb.append(pq.poll()).append(" ");
					}else {
						sb.append("-1").append(" ");
					}
				}
			}
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		} // testcase
		bw.flush();
	}
}