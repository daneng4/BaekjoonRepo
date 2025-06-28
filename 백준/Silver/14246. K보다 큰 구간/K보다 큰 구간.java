import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int k = Integer.parseInt(br.readLine());

		long count = 0;

		for(int start = 0; start < n; start++){
			long sum = 0;
			for(int end = start; end < n; end++){
				sum += arr[end];
				if(sum > k){
					count += (n-end);
					break;
				}
			}
		}

		System.out.println(count);
	}
}
