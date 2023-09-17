import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            char str = arr[i];
            if(str == '('){ // '(' 이면 push
                stack.push(str);
                continue;
            }
            if(str == ')'){ // ')' 이면 pop
                stack.pop();
                if (arr[i-1] == '('){ // 만약 ')' 전 문자가 '(' 라면
                    // 레이저
                    result += stack.size();
                }else // ')' 전 문자가 ')' 라면 그냥 막대기 이므로
                    result += 1;
            }

        }
        System.out.println(result);
    }
}