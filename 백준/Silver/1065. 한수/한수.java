import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 1; i<=N; i++) {
			String number = String.valueOf(i);
			if(number.length() == 1 || number.length() == 2) {
				count++;
				continue;
			}
			
			int diff = number.charAt(1) - number.charAt(0);
			
			for(int j = 2; j<number.length(); j++) {
				if(number.charAt(j) - number.charAt(j-1) == diff)
					count++;
			}
		}

		System.out.println(count);
	}
}
