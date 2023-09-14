import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            if (operator.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                continue;
            }else if(operator.equals("pop")){
                if (stack.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(stack.pop()).append("\n");
                continue;
            }else if(operator.equals("top")){
                if (stack.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(stack.peek()).append("\n");
                continue;
            }else if(operator.equals("size")){
                sb.append(stack.size()).append("\n");
                continue;
            }else if(operator.equals("empty")){
                if (stack.isEmpty())
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
                continue;
            }
        }
        System.out.println(sb);

    }
}