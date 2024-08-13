
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			stack = new Stack<>();
			String str = br.readLine();
			if(str.equals("."))
				break;
			
			boolean no = false;
			for(int i = 0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.push(c);
				}else if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						no = true;
						break;
					}
					stack.pop();
					
				}else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '['){
						no = true;
						break;
					}
					stack.pop();
				}
			}
			
			if(no) {
				sb.append("no\n");
			}else if(!stack.isEmpty())
				sb.append("no\n");
			else
				sb.append("yes\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}