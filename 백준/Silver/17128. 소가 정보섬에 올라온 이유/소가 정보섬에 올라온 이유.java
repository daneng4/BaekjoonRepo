import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] cows = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n+1];
        int total = 0;
        // 전체 합을 구하고 total에 누적
        for(int i = 1; i<=n; i++){
            int temp = 1;
            for(int j = 0; j<4; j++){
                int idx = i + j;
                if(idx > n){
                    idx -= n;
                }
                temp *= cows[idx];
            }
            total += temp;
            sum[i] = temp;
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<q; i++){
            int changedIdx = Integer.parseInt(st.nextToken());
            for(int j = 0; j<4; j++){
                if(changedIdx < 1){
                    changedIdx += n;
                }

                // 장난친 숫자 포함하는 sum의 부호 변경
                sum[changedIdx] *= -1;
                total += sum[changedIdx] * 2;

                changedIdx--;
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
