import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = 10;
		
		for(int t = 1; t<=test_case; t++) {
			int len = Integer.parseInt(br.readLine());
			String line = br.readLine();
			
			StringBuilder answer = new StringBuilder();
			Stack<Character> op = new Stack<>();
			
			for(int i = 0; i<len; i++) {
				char cur = line.charAt(i);
				if(cur == '(') {
					op.push(cur);
					continue;
				}else if(cur >='0' && cur<='9') {
					answer.append(cur);
					continue;
				}
				
				while(!op.empty() && op.peek() != '(' && checkPriority(op.peek()) >= checkPriority(cur)) {
					answer.append(op.pop());
				}
				if(cur==')')
					op.pop();
				else
					op.push(cur);
			}
			
			Stack<Integer> calculator = new Stack<>();
            for (int i = 0; i < answer.length(); i++) {
                char ch = answer.charAt(i);
                switch (ch) {
                    case '+':
                        calculator.push(calculator.pop() + calculator.pop());
                        break;
                    case '*':
                        calculator.push(calculator.pop() * calculator.pop());
                        break;
                    default:
                        calculator.push(ch - '0');
                        break;
                }
            }
			
            bw.write(String.format("#%d %d\n", t, calculator.pop()));
		} // testcase
		bw.flush();
			
	}	
	public static int checkPriority(char ch) {
		switch(ch){
        case '(': case ')':return 0;
        case '+': case '-':return 1;
        case '*': case '/':return 2;
		}
		
		return -1;
	}
}
