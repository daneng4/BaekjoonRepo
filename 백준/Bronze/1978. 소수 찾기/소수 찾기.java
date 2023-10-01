import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1)
                continue;
            for(int j = 1; j<=num; j++){
                if(num % j == 0 && j != 1 && j != num){ // num이 j로 나눠떨어졌고 j가 1이나 num 자신이 아닌경우 소수가 아닌 수
                    break;
                }
                if(j == num)
                    count++;
            }


        }
        System.out.println(count);
    }
}
