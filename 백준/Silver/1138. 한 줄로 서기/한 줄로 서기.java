import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n; i>=1; i--){
            list.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
