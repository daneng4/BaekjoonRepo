
import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=testcase; tc++) {
			answer = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			dfs(0);
			
			bw.write(String.format("#%d %d\n", tc, answer));
		}
		bw.flush();
		bw.close();
	}
	static void dfs(int depth) {
		if(depth == n) {
			answer += 1;
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		}
	}
	static boolean check(int depth) {
		for(int i = 0; i<depth; i++) {
			// arr[depth] == arr[i] : 같은 열 체크
			// depth - i == Math.abs(arr[depth] - arr[i]) : 대각선 체크
			if(arr[depth] == arr[i] || depth - i == Math.abs(arr[depth] - arr[i]))
				return false;
		}
		return true;
	}
}