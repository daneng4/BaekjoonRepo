
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
				
	}
	public static int factorial(int n) {
		int result = 1;
		for(int i = n; i>=1; i--) {
			result *= i;
		}
		return result;
	}
}