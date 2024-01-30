
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] sum = new long[n+1];
		long[] remain = new long[m];
		sum[0] = 0;
		
		long count = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1] + num) % m;
			if(sum[i] == 0)
				count++;
			remain[(int)sum[i]]++;
		}
		
		for(int i = 0; i<m; i++) {
			if(remain[i] > 1)
				count += (remain[i] * (remain[i]-1) / 2);
		}
		
		System.out.println(count);
	}

}
