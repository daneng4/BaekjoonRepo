import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.System.exit;

public class Main {

    public static int n;
    public static long[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n+2];
        arr[0] = 0;
        arr[1] = 1;
        if(n == 0){
            System.out.println(arr[0]);
            exit(0);
        }else if (n==1){
            System.out.println(arr[1]);
            exit(0);
        }

        for(int i = 2; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            if(n == i)
                System.out.println(arr[i]);
        }
    }
}