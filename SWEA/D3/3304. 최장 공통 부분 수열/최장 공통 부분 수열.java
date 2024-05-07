
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int alen = a.length();
			int blen = b.length();
			int[][] dp = new int[alen+1][blen+1];
			
			for(int i = 1; i<=alen; i++) {
				for(int j = 1; j<=blen; j++) {
					if(a.charAt(i-1) == b.charAt(j-1))
						dp[i][j] = dp[i-1][j-1] + 1;
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			bw.write(String.format("#%d %d\n", test, dp[alen][blen]));
		}
		bw.flush();
	}

}