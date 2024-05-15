import java.util.*;
import java.io.*;

public class Solution {
	static char[] op = {'+', '*'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = 10;
        
        for (int tc = 1; tc <= t; tc++) {
        	StringBuilder sb = new StringBuilder();
        	int len = Integer.parseInt(br.readLine());
        	String str = br.readLine();
        	Stack<Character> stack = new Stack<>();
        	
        	for(int i = 0; i<len; i++) {
        		char now = str.charAt(i);
        		// 연산자인 경우
        		if(checkOp(now)) {
        			// 현재연산자가 + 인 경우
        			if(now == '+') {
        				while(!stack.isEmpty()) {
        					char pop = stack.pop();
        					sb.append(pop);
        				}
        				stack.push(now);
        			} // 현재 연산자가 * 인 경우
        			else {
        				if(stack.isEmpty())
        					stack.push(now);
        				else {
        					while(stack.peek() == '*') {
            					char pop = stack.pop();
            					sb.append(pop);
            					if(stack.isEmpty())
            						break;
            				}
        					stack.push(now);
        				}
        				
        			}
        		}
        		// 피연산자인 경우
        		else {
        			sb.append(now);
        		}
        	}
        	
        	while(!stack.isEmpty()) {
        		sb.append(stack.pop());
        	}
        	
        	int answer = cal(sb.toString());
        	
        	bw.write(String.format("#%d %d\n", tc, answer));
        }// tc
        bw.flush();
    }
    public static boolean checkOp(char c) {
    	for(int i = 0; i<op.length; i++) {
    		if(c == op[i])
    			return true;
    	}
    	return false;
    }
    public static int cal(String sb) {
    	Stack<Integer> num = new Stack<>();
    	
    	for(int i = 0; i<sb.length(); i++) {
    		char now = sb.charAt(i);
    		// 연산자 이면
    		if(checkOp(now)) {
    			if(now == '+') {
    				num.push(num.pop() + num.pop());
    			}else {
    				num.push(num.pop() * num.pop());
    			}
    		}
    		// 피연산자 이면
    		else {
    			num.push(now - '0');
    		}
    	}
    	
    	return num.pop();
    }
}