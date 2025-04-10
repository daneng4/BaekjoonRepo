import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new Integer[n+1][n+1];
        int result = bc(n, k);
        System.out.println(result);
    }
    static int bc(int n, int k){
        if(k == 0 || n == k)
            return 1;

        if(dp[n][k] == null)
            dp[n][k] = bc(n-1, k) + bc(n-1, k-1);

        return dp[n][k] % 10007;
    }
}
