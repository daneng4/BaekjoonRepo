import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        int sum = 0;

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
        }
        Arrays.sort(array, Collections.reverseOrder());

        int count = 1;
        int free = 0;

        for(int i = 0; i<array.length; i++){
            if(count % 3 == 0){
                free += array[i];
                count = 0;
            }
            sum += array[i];
            count++;
        }

        sum = sum - free;
        System.out.println(sum);

    }
}