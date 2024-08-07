import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(!stack.isEmpty())
					stack.pop();
			}else {
				stack.push(num);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}