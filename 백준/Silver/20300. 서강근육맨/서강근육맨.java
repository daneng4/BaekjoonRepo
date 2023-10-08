import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        long[] gss = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            gss[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(gss);

        int length = gss.length;
        long result = 0;

        if(length % 2 == 0){ // 짝수
            for(int i = 0; i<length/2; i++){
                result = Math.max(result, gss[i] + gss[length - 1 - i]);
            }
        }else { // 홀수
            result = gss[length-1];
            for(int i = 0; i<(length-1)/2; i++){
                result = Math.max(result, gss[i] + gss[length - 2 - i]);
            }
        }

        System.out.println(result);

    }
}