import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        double sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            drink[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drink);

        for(int i = 0; i<drink.length; i++){
            if(i == drink.length-1)
                sum += drink[drink.length-1];
            else
                sum += (double) drink[i] /2;
        }

        System.out.println(sum);
    }
}