import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);
		for(int i = 0; i<n; i++){
			int cur = arr[i];
			for(int j = 0; j<i; j++){
				int ex = arr[j];
				if(ex < cur){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for(int i = 0; i<n; i++){
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
