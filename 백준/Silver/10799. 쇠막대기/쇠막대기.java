import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);

			if(c == '('){
				stack.push(c);
			}else{
				if(str.charAt(i-1) == '('){
					// 레이저 -> 스택 size만큼 +
					stack.pop();
					answer += stack.size();
				}else{
					// 막대의 끝 -> +1
					answer += 1;
					stack.pop();
				}
			}
		}

		System.out.println(answer);
	}
}
