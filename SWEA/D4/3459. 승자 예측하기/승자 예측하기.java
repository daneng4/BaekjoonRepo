
import java.io.*;
import java.util.*;

class Solution {
	static ArrayList<Long> min;
	static ArrayList<Long> max;
	static String bob = "Bob";
	static String alice = "Alice";
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			long N = Long.parseLong(br.readLine());
            String s = "Alice";
            while(N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
            }
            if( N == 1 || (N >= 6 && N <= 9)){
                s = "Bob";
            }
            bw.write("#"+test_case+" "+s+"\n");
		
		} // end of testcase
		bw.flush();
	}
}
