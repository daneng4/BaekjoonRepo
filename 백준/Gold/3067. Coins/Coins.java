import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i<=n; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];

            dp[0] = 1;
            for(int i = 1; i<=n; i++){
                for(int j = coins[i]; j<=m; j++){
                    dp[j] += dp[j-coins[i]];
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}
