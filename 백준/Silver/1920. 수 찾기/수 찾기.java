
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(find(target, num))
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}
		System.out.println(sb.toString());
	}
	public static boolean find(int target, int[] num) {
		int start = 0;
		int end = num.length-1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(num[mid] == target)
				return true;
			else if(num[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return false;
	}
}
