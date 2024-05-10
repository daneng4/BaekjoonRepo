import java.util.*;
import java.io.*;

public class Solution {
	static final char g1open = '(';
	static final char g2open = '[';
	static final char g3open = '{';
	static final char g4open = '<';
	static final char g1close = ')';
	static final char g2close = ']';
	static final char g3close = '}';
	static final char g4close = '>';
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = 10;
		for (int t = 1; t <= testCase; t++) {
			int g1openCount = 0; int g1closeCount = 0;
			int g2openCount = 0; int g2closeCount = 0;
			int g3openCount = 0; int g3closeCount = 0;
			int g4openCount = 0; int g4closeCount = 0;
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i = 0; i<n; i++) {
				if(str.charAt(i) == '(')
					g1openCount++;
				else if(str.charAt(i) == ')')
					g1closeCount++;
				else if(str.charAt(i) == '[')
					g2openCount++;
				else if(str.charAt(i) == ']')
					g2closeCount++;
				else if(str.charAt(i) == '{')
					g3openCount++;
				else if(str.charAt(i) == '}')
					g3closeCount++;
				else if(str.charAt(i) == '<')
					g4openCount++;
				else
					g4closeCount++;
			}
			boolean isRight = true;
			if(g1openCount != g1closeCount)
				isRight = false;
			if(g2openCount != g2closeCount)
				isRight = false;
			if(g3openCount != g3closeCount)
				isRight = false;
			if(g4openCount != g4closeCount)
				isRight = false;
			
			if(isRight)
				bw.write(String.format("#%d 1\n", t));
			else
				bw.write(String.format("#%d 0\n", t));
			
		} // testcase
		bw.flush();
	}
}