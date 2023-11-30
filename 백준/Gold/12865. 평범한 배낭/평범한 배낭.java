
import java.io.*;
import java.util.*;

public class Main {
	static int[] weight;
	static int[] value;
	static Integer[][] dp;
	static int n, k;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weight = new int[n];
		value = new int[n];
		dp = new Integer[n][k+1];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(find(n-1, k));
	}

	public static int find(int i, int k) {
		if(i<0)
			return 0;
		if(dp[i][k]==null) {
			if(weight[i] > k) {
				dp[i][k] = find(i-1, k);
			}else {
				dp[i][k] = Math.max(find(i-1, k), find(i-1,k -weight[i])+value[i]);
			}
		}
		return dp[i][k];
	}
}
