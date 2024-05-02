
import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			max = -1;
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<n-1; i++) {
				for(int j = i+1; j<n; j++) {
					check(arr[i] * arr[j]);
				}
			}
			
			bw.write(String.format("#%d %d\n", t, max));
		}
		
		bw.flush();
	
	}
	public static void check(int mul) {
		boolean increase = true;
		String str = String.valueOf(mul);
		int pre = str.charAt(0) - '0';
		
		for(int i = 1; i<str.length(); i++) {
			int cur = str.charAt(i) - '0';
			if(cur < pre) {
				increase = false;
				break;
			}
			pre = cur;
		}
		
		if(increase)
			max = Math.max(max, mul);
	}
}