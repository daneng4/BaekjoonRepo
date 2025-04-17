import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            Stack<Character> q = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i<str.length(); i++){
                char input = str.charAt(i);
                if(input == '<'){
                    if(!stack.isEmpty())
                        q.add(stack.pop());
                }else if (input == '>'){
                    if(!q.isEmpty()){
                        stack.push(q.pop());
                    }
                }else if(input == '-'){
                    if(!stack.isEmpty())
                        stack.pop();
                }else{
                    stack.push(input);
                }
            }

            while(!q.isEmpty()){
                stack.push(q.pop());
            }

            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            answer.append(sb.reverse()).append("\n");
        }

        System.out.println(answer);
    }
}
