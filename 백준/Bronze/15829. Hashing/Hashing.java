
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		// 'a' - '0' - 25
		long sum = 0;
		for(int i = 0; i<str.length; i++) {
			int num = str[i] - '0' - 48;
			
			sum += num * Math.pow(31, i) % 1234567891;
		}
		
		System.out.println(sum);
	}

}