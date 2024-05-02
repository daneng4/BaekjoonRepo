
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			boolean[] num = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m; i++) {
				int idx = Integer.parseInt(st.nextToken());
				num[idx] = true;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i<=n; i++) {
				if(!num[i])
					sb.append(i).append(" ");
			}
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		}
		bw.flush();
	}
}