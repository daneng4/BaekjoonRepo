import java.io.*;
import java.util.*;

public class Solution {
	static boolean isPossible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=t; test++) {
			int num = Integer.parseInt(br.readLine());
			int len = String.valueOf(num).length();
			if(len == 1) {
				bw.write(String.format("#%d impossible\n", test));
				continue;
			}
			
			isPossible = false;
			int mul = 2;
			// 입력된 수 x의 n배수가 x로 나누어 떨어지는지 확인
			// 단, n은 x의 자리수 개수가 바뀌지 않을 때 까지
			while(true) {
				int newNum = num * mul;
				String newstr = String.valueOf(newNum);
				if(newstr.length() != len) {
					break;
				}else {
					if(newNum % num == 0) {
						if(check(newNum, num)){
							isPossible = true;
							break;
						}
					}
				}
				mul++;
			}
			
			if(isPossible)
				bw.write(String.format("#%d possible\n", test));
			else
				bw.write(String.format("#%d impossible\n", test));
		}
		
		bw.flush();
	}
	public static boolean check(int newNum, int num) {
		String[] nn = String.valueOf(newNum).split("");
		String[] n = String.valueOf(num).split("");
		
		Arrays.sort(nn);
		Arrays.sort(n);
		
		for(int i = 0; i<nn.length; i++) {
			if(!nn[i].equals(n[i]))
				return false;
		}
		
		return true;
	}
}