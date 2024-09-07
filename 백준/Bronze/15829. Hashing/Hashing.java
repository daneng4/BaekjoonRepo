
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		// 'a' - '0' = 25
		long sum = 0;
		long pow = 1;
		for(int i = 0; i<len; i++) {
			sum += ((str.charAt(i) - 96) * pow);
			pow = (pow * 31) % 1234567891;
		}
		
		System.out.println(sum % 1234567891);
	}

}