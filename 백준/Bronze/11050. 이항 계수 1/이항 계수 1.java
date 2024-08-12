
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(f(n) / (f(n-k) * f(k)));
		
	}
	public static int f(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * f(n-1);
	}
}