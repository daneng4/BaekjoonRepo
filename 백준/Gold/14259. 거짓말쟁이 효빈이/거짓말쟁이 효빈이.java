import java.util.*;
import java.io.*;

public class Main {

    static int n, k, a, m;
    static int[] missiles;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        missiles = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<m; i++){
            missiles[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = m;
        int answer = -1;

        while(left <= right){
            int mid = (left + right)/2;
            if(canPlace(mid)){ // 더 많은 미사일을 쏴도 안 짐
                left = mid + 1;
            }else{ // 패배할 수 밖에 없음, 패배하는 최소 미사일 개수 찾기
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
    static boolean canPlace(int missleCount){
        boolean[] attacked = new boolean[n+2];

        for(int i = 0; i < missleCount; i++){
            attacked[missiles[i]] = true;
        }

        int count = 0;
        int length = 0;

        for(int i = 1; i<=n+1; i++){
            // 미사일 떨어지는 곳, 마지막 지점에 도달하면 지금까지 쌓은 length로 배 몇척 둘 수 있는지 계산
            if(attacked[i] || i == n+1){
                count += (length+1) / (a+1);
                length = 0;
            }else{
                length++;
            }
        }

        // 둘 수 있는 배가 k개 이상이면 거짓말을 해도 된다.
		return count >= k;
    }
}
