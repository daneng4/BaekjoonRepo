import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        long sum = 0;

        for(int i = 0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            array[i] = a;
        }
        Arrays.sort(array, Collections.reverseOrder());

        for(int i = 0; i<array.length; i++){
            array[i] = array[i] - i;
            if(array[i] < 0)
                array[i] = 0;
            sum += array[i];
        }

        System.out.println(sum);
    }
}