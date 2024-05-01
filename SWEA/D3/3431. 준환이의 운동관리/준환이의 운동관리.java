
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // l이상
			int u = Integer.parseInt(st.nextToken()); // u이하
			int x = Integer.parseInt(st.nextToken()); // 현재 한 운동
			
			StringBuilder sb = new StringBuilder();

			if(x < l) {
				sb.append(l-x);
			}else if(l<= x && x<=u) {
				sb.append(0);
			}else {
				sb.append(-1);
			}
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		}
		
		bw.flush();
	}
}