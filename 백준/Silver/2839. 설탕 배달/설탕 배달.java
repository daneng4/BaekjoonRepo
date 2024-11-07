
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int fiveCount = n / 5;
		int count = Integer.MAX_VALUE;
		boolean pos = false;
		
		for(int i = fiveCount; i >= 0; i--) {
			if(n % 5 == 0) {
				pos = true;
				count = Math.min(count, n / 5);
			}else if((n - (5 * i)) % 3 == 0){
				pos = true;
				int d =  (n - (5 * i)) / 3;
				count = Math.min(count, i + d);
			}
		}
		if(!pos)
			System.out.println(-1);
		else
			System.out.println(count);
	}
}