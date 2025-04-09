import java.io.*;
import java.util.*;

public class Main {
    static int result = Integer.MIN_VALUE;
    static int[][] quest;
    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        quest = new int[m][k];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++){
                quest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0,1, 0);
        System.out.println(result);
    }
    static void search(int idx, int cur, int bit){
        if(idx == n){
            check(bit);
            return;
        }
        if(cur > 2 * n){
            return;
        }
        search(idx+1, cur+1, bit | (1<<cur));
        search(idx, cur+1, bit);
    }
    static void check(int bit){
        int cnt = 0;
        for(int i=0;i<m;i++){
            boolean flag = false;
            for(int j=0;j<k;j++){
                if(((1<<quest[i][j]) & bit) == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                cnt++;
            }
        }
        result = Math.max(result, cnt);
    }
}
