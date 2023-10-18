import java.util.*;
import java.io.*;

public class Main {

    public static int[][] dp = new int[31][31];;
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 서쪽 사이트
            int m = Integer.parseInt(st.nextToken()); // 동쪽 사이트

            System.out.println(comb(m, n));
        }
        br.close();
    }
    public static int comb(int m, int n){
        if(dp[m][n] > 0)
            return dp[m][n];

        else if (m==n || n == 0)
            return dp[m][n] = 1;

        else
            return dp[m][n] = comb(m-1, n-1) + comb(m-1, n);
    }
}