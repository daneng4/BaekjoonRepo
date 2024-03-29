
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int k, n, m;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] table = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<str.length(); j++) {
				table[i][j] = str.charAt(j)-'0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int zero = 0;
			for(int j = 0; j<m; j++) {
				if(table[i][j] == 0)
					zero++;
			}
			int pattern = 0;
			if(zero <= k && zero % 2 == k % 2) {
				for(int j = 0; j<n; j++) {
					if(isSame(table[i], table[j], m))
						pattern++;
				}
			}
			answer = Math.max(answer, pattern);
		}
	
		System.out.println(answer);
	}
	public static boolean isSame(int[] table1, int[] table2, int m) {
		for(int i = 0; i<m; i++) {
			if(table1[i] != table2[i])
				return false;
		}
		return true;
	}
}