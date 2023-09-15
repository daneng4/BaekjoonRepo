import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Deque<Integer> q = new LinkedList<>();
       StringTokenizer st;
       StringBuilder sb = new StringBuilder();
       int N = Integer.parseInt(br.readLine());

       while(N-->0){
           st = new StringTokenizer(br.readLine());
           String operator = st.nextToken();

           switch (operator) {
               case "push":
                   int num = Integer.parseInt(st.nextToken());
                   q.add(num);
                   continue;
               case "pop":
                   if (q.isEmpty()) {
                       sb.append("-1").append("\n");
                       continue;
                   } else sb.append(q.poll()).append("\n");
                   break;
               case "size":
                   sb.append(q.size()).append("\n");
                   break;
               case "empty":
                   if (q.isEmpty()) sb.append("1").append("\n");
                   else sb.append("0").append("\n");
                   break;
               case "front":
                   if (q.isEmpty()) sb.append("-1").append("\n");
                   else sb.append(q.getFirst()).append("\n");
                   break;
               default:
                   if (q.isEmpty()) sb.append("-1").append("\n");
                   else sb.append(q.getLast()).append("\n");
                   break;
           }
       }
        System.out.println(sb);
    }
}