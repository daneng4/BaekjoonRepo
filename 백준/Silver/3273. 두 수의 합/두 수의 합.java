import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int count = 0;
		for(int i = 0; i<n; i++) {
			int ai = arr[i];
			int aj = target - ai;
			
			int start = 0;
			int mid;
			int end = arr.length-1;
			
			while(start <= end) {
				mid = (start+end)/2;
				if(aj == arr[mid]) {
					count++;
					break;
				}else if(aj < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		
		System.out.println(count/2);
		
	}
}