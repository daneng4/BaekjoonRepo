import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int result = 0;

        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    // 최대 길이 갱신
                    result = Math.max(dp[i], result);
                }
            }
        }


        sb.append(result + "\n");

        int value = result;
        Stack<Integer> stack = new Stack<>();
        for(int i = n; i >= 1; i--){
            // 현재 찾는 길이와 같은 경우
            if(value == dp[i]) {
                // stack에 실제 값을 push한다.
                stack.push(arr[i]);
                // 찾는 길이를 찾았으므로 -1을 해주어
                // 다음에 찾을 길이를 설정해준다.
                value--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}
