import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());


        while(T-- > 0){
            char[] c = br.readLine().toCharArray(); // 괄호로 이루어진 문자열을 char array로 변경
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i<c.length; i++) { // array의 크기만큼 반복
                if (c[i] == '(') { // 만약 입력 괄호가 ( 이라면
                    stack.push(c[i]); // 스택에 push
                } else if (c[i] == ')') { // 만약 입력 괄호가 ) 이고
                    if (stack.isEmpty()) { // 스택이 비어있다면 NO
                        System.out.println("NO");
                        break;
                    }else{ // 비어있지 않다면
                        stack.pop();
                    }
                }
                if (i == c.length-1 && stack.isEmpty()){ // reaLine의 마지막 괄호고 모든 연산이 끝난 뒤 stack이 비어있다면
                    System.out.println("YES");
                }else if (i == c.length-1 && !stack.isEmpty()){ // 연산이 끝났는데 스택에 ( 가 남아있다면
                    System.out.println("NO");
                }
            }
        }
    }
}