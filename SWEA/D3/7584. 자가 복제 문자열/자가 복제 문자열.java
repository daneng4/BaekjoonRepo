
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			
			long k = Long.parseLong(br.readLine())-1;
			int result = 0;
			
			while(k > 0) {
				if(k%2 == 1) 
					k = (k-1)/2;
				if(k%4 == 0) {
					result = 0; break;
				}
				else if(k%2 == 0) {
					result = 1; break;
				}
			}
			
			bw.write("#"+t+" "+result+"\n");
			
		} // testcase
		bw.flush();
	}
}