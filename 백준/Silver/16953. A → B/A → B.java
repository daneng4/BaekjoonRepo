import java.io.*;
import java.util.*;

public class Main {
    static long t;
    static boolean pos = false;
    static int result = 0;
    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        find(s, 0);

        if (!pos) {
            System.out.println(-1);
        }else
            System.out.println(result);
    }

    public static void find(long s, int count){
        if(pos)
            return;
        if(s > t)
            return;
        if(s == t){
            pos = true;
            result = count+1;
        }

        find(s*2, count+1);
        find(s*10+1, count+1);


    }
}
