
import java.util.*;
import java.io.*;

public class Main {
	static long c;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A를 B번 곱한 수를 C로 나눈 나머지
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// A가 C보다 큰 이후부터는 나머지가 동일하다.
		
		System.out.println(pow(a,b));
	}
	public static long pow(long a, long exp) {
		if(exp == 1) {
			return a % c;
		}
		
		long temp = pow(a, exp/2);
		
		if(exp % 2 == 1) {
			return (temp * temp % c) * a % c;
		}
		return temp * temp % c;
	}
}