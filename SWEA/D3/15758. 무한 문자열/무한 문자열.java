
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			BigInteger alen = BigInteger.valueOf(a.length());
			BigInteger blen = BigInteger.valueOf(b.length());
			int gcd = alen.gcd(blen).intValue(); // a와 b길이의 최대공약수
			int lcm = (a.length() * b.length()) / gcd;
			
			String arepeat = a; String brepeat = b;
			while(arepeat.length() != lcm) {
				arepeat += a;
			}
			while(brepeat.length() != lcm) {
				brepeat += b;
			}
			
			if(arepeat.equals(brepeat))
				bw.write(String.format("#%d yes\n", t));
			else
				bw.write(String.format("#%d no\n", t));
		} // testcase
		bw.flush();
	}
}