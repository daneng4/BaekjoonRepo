import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int[] prefix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		prefix = new int[n+1];
		
		st = new StringTokenizer(br.readLine());

		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		for(int i = 1; i<=n; i++) {
			prefix[i] = prefix[i-1] + arr[i];
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = quest(a,b);
			sb.append(result).append("\n");
		}

		System.out.println(sb.toString());
	}
	public static int quest(int a, int b) {
		return prefix[b] - prefix[a-1];
	}
}