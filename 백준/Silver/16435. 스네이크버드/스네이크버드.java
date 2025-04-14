import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] fruits = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fruits);

        for(int i = 0; i<n; i++){
            if(fruits[i] > l){
                break;
            }
            l++;
        }

        System.out.println(l);
    }
}
