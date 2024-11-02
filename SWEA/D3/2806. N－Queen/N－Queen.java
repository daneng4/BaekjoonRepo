import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static int n, answer;
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			answer = 0;
			
			dfs(0);
			bw.write(String.format("#%d %d\n", tc, answer));
			
		}
		bw.flush();
		bw.close();
		br.close();
    }
	static void dfs(int depth) {
		if(depth == n) {
			answer += 1;
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				dfs(depth + 1);
			}
		}
	}
	static boolean possible(int depth) {
		for(int i = 0; i<depth; i++) {	
			if(arr[depth] == arr[i] || depth - i == Math.abs(arr[depth] - arr[i]))
				return false;
		}
		return true;
	}
}
