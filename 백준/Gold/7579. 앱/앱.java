import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n];
        int[] cost = new int[n];
        int[][] dp = new int[n][10001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int c = cost[i];
            int mem = memory[i];

            // j = 앱을 비활성하기 위한 총 cost
            for(int j = 0; j<=10000; j++){
                // 앱을 하나만 비활성화 할 수 있을 때
                if(i == 0){
                    // 총 cost j가 비활성화에 필요한 c보다 크면, mem을 확보할 수 있다.
                    if(j >= c) dp[i][j] = mem;
                }
                // 앱을 여러개 비활성화 할 수 있을 때
                else{
                    // 총 cost j가 비활성화에 필요한 c보다 크면, 이번 앱을 비활성 / 비활성안함 중 최대를 고른다.
                    // dp[i-1][j-c] + mem을 하는 이유는 이번 앱을 비활성화하기 이전까지 얼마나 확보했는지 확인하고
                    // 현재 mem을 더하는 것
                    if(j >= c) dp[i][j] = Math.max(dp[i-1][j-c] + mem, dp[i-1][j]);
                    // 비활성화에 필요한 cost j가 더 적으면 이번 앱 비활성 안하고 그냥 유지
                    else dp[i][j] = dp[i-1][j];
                }
                // 정답 갱신 로직
                // dp[i][j] 는 0~i 앱까지 비활성화에 비용을 j만큼 썼을 때 확보 가능한 최대 메모리
                if(dp[i][j] >= m) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}
