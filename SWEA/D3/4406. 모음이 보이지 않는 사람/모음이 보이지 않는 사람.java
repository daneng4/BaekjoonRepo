import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			char[] vowel = {'a','e','i','o','u'};
			char[] c = str.toCharArray();
			
			
			for(char element : c) {
				boolean isVowel = false;
				
				for(char v : vowel) {
					if(element == v) {
						isVowel = true;
						break;
					}
				}
				if(isVowel)
					continue;
				sb.append(element);
			}
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
			
		} // testcase
		bw.flush();
	}
}