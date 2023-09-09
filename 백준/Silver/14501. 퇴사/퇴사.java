import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int result;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 일하는 날
        StringTokenizer st = null;
        arr = new int[n][2]; // 걸리는 시간 & 수익

        for(int i = 0; i<n; i++) { // 1일부터 시작
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 상담에 걸리는 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 보수
        }

        result = 0;
        dfs(0,0);
        System.out.println(result);

    }
    public static void dfs(int day, int pay) {
        if (day >= n) {
            // 다 일 했으면 리턴
            result = Math.max(pay, result);
            return;
        }

        // 상담을 끝낼 수 있으면 상담이 끝난 날짜와 보수 넣음
        if (day + arr[day][0] <= n){
            dfs(day + arr[day][0], pay + arr[day][1]);
        }else { // 상담을 못 끝내면 날짜만 넘김
            dfs(day + arr[day][0], pay);
        }

        dfs(day+1, pay);
    }
}