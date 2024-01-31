
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		int start = 0;
		int end = n - 1;
		int count = 0;
		
		while(start < end) {
			int sum = num[start] + num[end];
			
			if(sum < m) {
				start++;
			}else if(sum == m) {
				count++;
				start++;
				end--;
			}else {
				end--;
			}
		}
		
		System.out.println(count);
		
	}
}
