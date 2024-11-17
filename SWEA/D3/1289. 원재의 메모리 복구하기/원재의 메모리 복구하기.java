import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=testcase; tc++) {
			String[] original = br.readLine().split("");
			int answer = 0;
			
			if(!original[0].equals("0"))
				answer++;
			
			if(original.length == 1) {
				bw.write(String.format("#%d %d\n", tc, answer));
				continue;
			}
			
			for(int i = 1; i<original.length; i++) {
				if(original[i].equals(original[i-1]))
					continue;
				answer++;
			}
			
			bw.write(String.format("#%d %d\n", tc, answer));
		}
		bw.flush();
		bw.close();
		
	}
}