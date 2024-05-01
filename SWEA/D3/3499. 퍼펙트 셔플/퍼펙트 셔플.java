
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] a = new String[n/2+1];
			String[] b = new String[n/2];
			String[] answer = new String[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if(n % 2 == 0) {
				for(int i = 0; i<n/2; i++) {
					a[i] = st.nextToken();
				}
				for(int i = 0; i<n - n/2; i++) {
					b[i] = st.nextToken();
				}
			}else {
				for(int i = 0; i<n/2+1; i++) {
					a[i] = st.nextToken();
				}
				for(int i = 0; i<n - (n/2+1); i++) {
					b[i] = st.nextToken();
				}
			}
			
			int aidx = 0; int bidx = 0;
			for(int i = 1; i<=n; i++) {
				if(i % 2 == 1) {
					answer[i-1] = a[aidx++];
				}else {
					answer[i-1] = b[bidx++];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(String e : answer) {
				sb.append(e).append(" ");
			}
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		}
		
		bw.flush();
	}	
}