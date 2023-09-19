import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            int[] arr= {i+1,Integer.parseInt(st.nextToken())};
            q.add(arr);
        }

        while(q.size()>1){
            int[] arr= q.pollFirst();
            sb.append(arr[0]).append(" ");
            int next = arr[1];

            if(next > 0){ // 종이에 적힌 숫자가 양수인 경우
                for(int j = 1; j<next; j++){
                    q.offerLast(q.pollFirst());
                }
            }else{
                for(int j = next; j!=0; j++){
                    q.offerFirst(q.pollLast());
                }
            }

        }
        sb.append(q.poll()[0]).append(" ");
        System.out.println(sb);
    }
}