import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            long result = 0;
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i = 0; i<K; i++){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while(true){
                Long a = pq.poll();
                Long b = pq.poll();
                result += a+b;
                if(pq.isEmpty())
                    break;
                pq.offer(a+b);
            }
            System.out.println(result);

        }

    }
}
