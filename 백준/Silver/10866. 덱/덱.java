import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Deque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            switch (operator){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dq.addFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dq.addLast(num);
                    break;
                case "pop_front":
                    if(dq.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }else{
                        sb.append(dq.pollFirst()).append("\n");
                        break;
                    }
                case "pop_back":
                    if(dq.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }else{
                        sb.append(dq.pollLast()).append("\n");
                        break;
                    }
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append("1").append("\n");
                        break;
                    }else{
                        sb.append("0").append("\n");
                        break;
                    }
                case "front":
                    if(dq.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }else{
                        sb.append(dq.peekFirst()).append("\n");
                        break;
                    }
                case "back":
                    if(dq.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }else{
                        sb.append(dq.peekLast()).append("\n");
                        break;
                    }
            }
        }
        System.out.println(sb);
    }
}