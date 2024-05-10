import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=test_case; t++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int pieces = 0;
			
			for(int i = 0; i<str.length(); i++) {
				// ( 오면 stack에 push
				if(str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				} 
				// ) 인데 바로전에 ( push했다면 이건 레이저 배치 정보
				else if(str.charAt(i) == ')' && str.charAt(i-1) == '(') {
					stack.pop();
					int size = stack.size();
					pieces += size;
				} 
				// ) 인데 바로 직전 인덱스가 ( 가 아닌 경우 이건 막대의 끝 정보
				else if(str.charAt(i) == ')' && str.charAt(i-1) != '(') {
					stack.pop();
					pieces++;
				}
			}
			
			bw.write(String.format("#%d %d\n", t, pieces));
		} // testcase
		bw.flush();
			
	}	
}