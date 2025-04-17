import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] nge = new int[n];
        for(int i = n-1; i>=0; i--){
            int number = num[i];
            if(stack.isEmpty()){
                nge[i] = -1;
                stack.push(number);
                continue;
            }
            while(true){
                if(stack.isEmpty()){
                    nge[i] = -1;
                    break;
                }
                if(stack.peek() > num[i]){
                    nge[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(number);
        }

        StringBuilder sb = new StringBuilder();
        for(int element : nge){
            sb.append(element).append(" ");
        }

        System.out.println(sb);
    }
}
