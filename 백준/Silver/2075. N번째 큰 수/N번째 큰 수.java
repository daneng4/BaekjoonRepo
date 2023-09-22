import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
            }
        }

        for(int i = 0; i<n-1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());


    }
}