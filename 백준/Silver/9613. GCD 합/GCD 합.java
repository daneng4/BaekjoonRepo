import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            long sum = 0;

            for(int j = 0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    sum += gcd(arr[j], arr[k]);
                }
            }
            System.out.println(sum);

        }


    }
    static int gcd(int x, int y){ // 최소 공배수 구하는 메서드
        if(x % y == 0)
            return y;
        return gcd(y, x%y);
    }
}
