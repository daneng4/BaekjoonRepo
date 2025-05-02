import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int top = 1;
		boolean flag = false;

		while(n-- > 0){
			int num = Integer.parseInt(br.readLine());
			// 일단 삽입
			for(int i = top; i<=num; i++){
				stack.push(i);
				sb.append("+\n");
				top++;
			}

			// num 찾을때까지 stack pop
			while(true){
				if(stack.isEmpty()){
					flag = true;
					break;
				}
				if(stack.peek() == num){
					stack.pop();
					sb.append("-\n");
					break;
				}else{
					stack.pop();
					sb.append("-\n");
				}
			}

			if(flag)
				break;
		}

		if(flag)
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}
