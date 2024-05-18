import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = 10;
		for(int t = 1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for(int i = 3; i<=n-2; i++) {
				answer += check(i);
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		}
		
		bw.flush();
	}
	public static int check(int x) {
		if(arr[x-2] >= arr[x]) 
			return 0;
		if(arr[x-1] >= arr[x])
			return 0;
		if(arr[x+1] >= arr[x])
			return 0;
		if(arr[x+2] >= arr[x])
			return 0;
		
		int result = Math.max(arr[x-2], Math.max(arr[x-1], Math.max(arr[x+1], arr[x+2])));
		return arr[x] - result;
	}
}