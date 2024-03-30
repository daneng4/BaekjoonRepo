
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] n = br.readLine().toCharArray();
		
		int zero = 0;
		int one = 0;
		int pre = -1;
		
		for(int i = 0; i<n.length; i++) {
			if(n[i] == '0') {
				if(pre != 0) {
					zero++;
					pre = 0;
				}
			}else {
				if(pre != 1) {
					one++;
					pre = 1;
				}
			}
		}
		
		if(zero >= one)
			System.out.println(one);
		else
			System.out.println(zero);
		
	}
}