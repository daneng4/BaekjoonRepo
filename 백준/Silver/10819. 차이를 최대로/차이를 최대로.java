import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] seq;
    static boolean[] visit;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        seq = new int[n];
        visit = new boolean[n];

        for(int i = 0 ; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0);

        System.out.println(max);
    }
    public static void find(int count){
        if(count == n){
            int sum = 0;
            for(int i = 0; i<n-1; i++){
                sum += Math.abs(seq[i] - seq[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                seq[count] = arr[i];
                find(count + 1);
                visit[i] = false;
            }
        }
    }
}
