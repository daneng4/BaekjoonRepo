import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // 제거 할 사람의 인덱스? 제거 간격?
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            q.add(i);
        }
        sb.append("<");

        while(q.size()>1){
            for(int i = 0; i<k-1; i++){
                int value = q.poll();
                q.add(value);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}