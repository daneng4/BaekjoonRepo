
import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(bs(num)<0)
				sb.append("0").append("\n");
			else
				sb.append("1").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	public static int bs(int target) {
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(target > arr[mid])
				start = mid+1;
			else if(target < arr[mid])
				end = mid-1;
			else
				return mid;
		}
		return -1;
	}
}