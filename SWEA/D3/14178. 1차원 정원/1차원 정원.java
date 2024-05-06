import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testNumber = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testNumber; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			boolean[] plant = new boolean[n+1];
			
			int start = 1+d;
			int count = 0;
			// 만약 시작 부분이 n보다 크면 한개로 충분함
			if(start >= n) {
				count = 1;
				bw.write(String.format("#%d %d\n", t, count));
			}else {
				for(int i = start; i <= n; i += (d*2)+1) {
					for(int j = i - d; j<= i + d; j++) {
						if(j < 1 || j > n)
							continue;
						plant[j] = true;
					}
					count++;
				}
				
				for(int i = 1; i<=n; i++) {
					if(!plant[i]) {
						count++;
						break;
					}
				}
				
				bw.write(String.format("#%d %d\n", t, count));
			}
			
		}
		
		bw.flush();
	}
}