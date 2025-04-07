import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] op;
    static int[] seq;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        op = new int[4];
        seq = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        run(0);
        System.out.println(max);
        System.out.println(min);
    }
    static void run(int idx){
        if(idx == n-1){
            cal();
            return;
        }

        for(int i = 0; i<4; i++){
            if(op[i] == 0)
                continue;

            op[i]--;
            seq[idx] = i;
            run(idx + 1);
            op[i]++;
        }
    }
    static void cal(){
        int result = arr[0];
        for(int i = 0; i<n-1; i++){
            if(seq[i] == 0){
                result += arr[i+1];
            }else if(seq[i] == 1){
                result -= arr[i+1];
            }else if(seq[i] == 2){
                result *= arr[i+1];
            }else{
                result /= arr[i+1];
            }
        }

        max = Math.max(result, max);
        min = Math.min(result, min);
    }
}
