import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    static int k,n;
    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 마지막 돌을 제외한 모든 돌에는 소비하는 에너지가있다.
        arr = new int[n+1][2];

        for(int i = 1; i<=n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            arr[i][0] = small;
            arr[i][1] = big;
        }
        k = Integer.parseInt(br.readLine()); // 매 큰 점

        solve(0,1,false);
        System.out.println(result);

    }
    public static void solve(int sum, int to, boolean chance){
        if(to == n){
            result = Math.min(result, sum);
            return;
        }
        if(to > n){
            return;
        }
        solve(sum + arr[to][0], to + 1, chance);
        solve(sum + arr[to][1], to + 2, chance);
        if(!chance){
            solve(sum+k, to+3, true);
        }

    }
}
