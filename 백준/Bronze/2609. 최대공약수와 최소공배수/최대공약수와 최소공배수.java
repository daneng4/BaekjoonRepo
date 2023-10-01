import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a,b);
        int lcm = gcd * (a/gcd) * (b/gcd);

        System.out.println(gcd);
        System.out.println(lcm);

    }
    static int gcd(int a, int b){
        if (a%b == 0)
            return b;
        return gcd(b, a%b);
    }
}
