
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1]; // 악보 배열
		int[] sum = new int[n+1]; // 실수 누적합 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 현재 악보가 이전 악보보다 작다.
			if(arr[i] < arr[i-1])
				sum[i-1]++;
		}

		for(int i = 1; i<=n; i++) {
			sum[i] += sum[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == b)
				sb.append(0).append("\n");
			else
				sb.append(sum[b-1] - sum[a-1]).append("\n");
		}
		System.out.println(sb);
	}
}