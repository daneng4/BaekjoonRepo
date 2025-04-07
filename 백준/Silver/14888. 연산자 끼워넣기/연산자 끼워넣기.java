import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] op;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        run(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void run(int idx, int cur){
        if(idx == n){
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        for(int i = 0; i<4; i++){
            if(op[i] == 0)
                continue;

            if(i == 0){
                op[i]--;
                run(idx + 1, cur + arr[idx]);
                op[i]++;
            }
            else if(i == 1){
                op[i]--;
                run(idx + 1, cur - arr[idx]);
                op[i]++;
            }
            else if(i == 2){
                op[i]--;
                run(idx + 1, cur * arr[idx]);
                op[i]++;
            }
            else {
                op[i]--;
                run(idx + 1, cur / arr[idx]);
                op[i]++;
            }
        }
    }
}
