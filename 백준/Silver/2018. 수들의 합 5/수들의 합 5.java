
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = start;
		int sum = 0;
		int count = 0;
		
		while(start <= n) {
			// 합이 n보다 작으면 end ++;
			if(sum < n) {
				sum+=end;
				end++;
			} // 합이 n과 같으면
			else if (sum == n) {
				count++;
				sum -= start;
				start++;
			} // 합이 n보다 크면
			else {
				sum -= start;
				start++;
			}
			
		}
		System.out.println(count);
		
	}

}
