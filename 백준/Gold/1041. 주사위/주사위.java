
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long[] arr = new long[6];
		long result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		
		if(n==1) {
			Arrays.sort(arr);
			for(int i = 0; i<arr.length-1; i++) {
				sum+=arr[i];
			}
			System.out.println(sum);
		}else {
			long[] mins = new long[3];
			for(int i = 0; i<3; i++) {
				long temp = Math.min(arr[i], arr[arr.length-i-1]);
				mins[i] = temp;
			}
			Arrays.sort(mins);
			long i1 = mins[0];
			long i2 = mins[0] + mins[1];
			long i3 = mins[0] + mins[1] + mins[2];
			
			//1. 1면만 노출되는 수
			result += i1 * (long)((n-1)*(n-2)*4 + (long)Math.pow(n-2, 2));
			//2. 2면만 노출되는 수
			result += i2 * (long)(4 * (n-1) + 4 * (n-2));
			//3. 3면만 노출되는 수
			result += i3 * 4;
			System.out.println(result);
		}
		
		
	}
}
