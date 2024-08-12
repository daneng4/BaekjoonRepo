
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<=1000000; i++) {
			int num = process(i);
			if(num == n)
				min = Math.min(i, min);
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
		
	}
	public static int process(int now) {
		int sum = now;
		String num = String.valueOf(now);
		for(int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}
		return sum;
	}
}