
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			bw.write("#" + t + " ");
			 
            String str = br.readLine();
            int cnt = str.length()-1;
            Double N = Double.parseDouble(str.substring(0, 3));
            N /= 10.0;
            N = Math.round(N)/10.0;
            if(N >= 10) {
                N /= 10.0;
                cnt++;
            }
            bw.write(N+"*10^"+cnt+"\n");
			
		}
		bw.flush();
	}
}