import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    if(stack.peek() != c){
                        stack.push(c);
                    }else{
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty())
                answer++;
        }

        System.out.println(answer);
    }
}
