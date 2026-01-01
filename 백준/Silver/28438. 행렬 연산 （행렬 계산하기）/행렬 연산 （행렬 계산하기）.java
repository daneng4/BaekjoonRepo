import java.io.*;
import java.util.*;

public class Main {
    static int[] row;
    static int[] col;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        row = new int[N+1];
        col = new int[M+1];

        for(int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if(query == 1){
                int r = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                query1(r, v);
            }else{
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                query2(c, v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                sb.append(row[i] + col[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void query1(int r, int v){
        row[r] += v;
    }
    public static void query2(int c, int v){
        col[c] += v;
    }
}