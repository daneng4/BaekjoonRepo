import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		int[] dp = new int[k+1];

		int answer = 0;
		for(int i = 1; i<=k; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			dp[i] = time;
			for(int j = 0; j<n; j++){
				int preWork = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i], dp[preWork] + time);
			}

			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
