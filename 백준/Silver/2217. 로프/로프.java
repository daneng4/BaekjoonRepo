import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 줄 수
        Integer[] rope = new Integer[n];

        for(int i = 0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            rope[i] = a;
        }
        Arrays.sort(rope);

        int b = 0;
        while(n-- > 0){
            rope[b] = rope[b] * (n+1);
            b++;
        }
        Arrays.sort(rope, Collections.reverseOrder());
        System.out.println(rope[0]);

    }
}