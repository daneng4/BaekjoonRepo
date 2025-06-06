import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = arr[i];
            for(int j = 0; j<i; j++){
                if(dp[i] > dp[j]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
