
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			String str = br.readLine();
			char[] num = str.toCharArray();
			int max = Integer.parseInt(str);
			int min = Integer.parseInt(str);
			
			for(int i = 0; i<num.length-1; i++) {
				for(int j = i+1; j<num.length; j++) {
					// 맨 앞자리에 0이 오면 안됨
					if(i == 0 && num[j] == '0')
						continue;
					
					int newNumber = makeNewNumber(num, i, j);
					
					max = Math.max(max, newNumber);
					min = Math.min(min, newNumber);
				}
			}
			
			bw.write(String.format("#%d %d %d\n", t, min, max));
			
		} // testcase
		bw.flush();
	}
	public static int makeNewNumber(char[] num, int i, int j) {
		StringBuilder sb = new StringBuilder();
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		
		for(char c : num) {
			sb.append(c);
		}
		
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		
		return Integer.parseInt(sb.toString());
	}
}