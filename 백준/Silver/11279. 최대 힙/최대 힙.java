import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i<n; i++){
           int mode = Integer.parseInt(br.readLine());
           if(mode == 0){ // list에서 최대값 출력
               if(pq.isEmpty()){ // 0인데 list가 비어있으면 0 출력
                   sb.append("0\n");
               }else{ // 비어있지않으면 최대값 출력
                   sb.append(pq.poll()).append("\n");
               }
           }else{
               pq.offer(mode);
           }
       }
        System.out.println(sb);
    }
}