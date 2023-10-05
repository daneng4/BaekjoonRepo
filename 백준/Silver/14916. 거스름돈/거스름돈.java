import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.System.exit;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count5 = 0;
        int count2 = 0;

        if (n < 5){ // 5 보다 작은 수
            if(n%2 != 0) { // 2로 나누어 떨어지지 않으면 거슬러 줄 수 없다
                System.out.println(-1);
                exit(0);
            }
            else // 나누어 떨어지면 n/2 몫이 2원 개수
                count2 = n/2;
        }else{ // 5보다 큰 수
            count5 = n / 5;
            n = n % 5;
            if (n % 2 != 0){
                count5 -= 1;
                n += 5;
            }
            count2 = n / 2;

        }
        System.out.println(count5 + count2);




    }
}