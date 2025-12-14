import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        sb1 = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(N == M){
            StringBuilder sb2 = new StringBuilder();
            for(int n : arr)
                sb2.append(n + " ");

            System.out.println(sb2);
            return;
        }


        solve(0, 0, "");

        System.out.println(sb1);
    }

    private static void solve(int len, int picked, String str){
        if(len == M){
            sb1.append(str + "\n");
            return;
        }

        for(int i = picked; i<N; i++){
            solve(len + 1, i + 1, str + arr[i] + " ");
        }
    }
}