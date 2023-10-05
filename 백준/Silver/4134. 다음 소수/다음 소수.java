import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            long n = Long.parseLong(br.readLine());
            BigInteger nextPrimeNumber = new BigInteger(String.valueOf(n));
            if (nextPrimeNumber.isProbablePrime(10))
                System.out.println(nextPrimeNumber);
            else
                System.out.println(nextPrimeNumber.nextProbablePrime());
        }

    }
}