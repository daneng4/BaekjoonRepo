import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        String[] arr = str.split(" ");
        for(int i = 0; i<arr.length;i++){
            if(arr[i].isEmpty())
                continue;
            else
                count++;
        }

        System.out.println(count);
    }
}