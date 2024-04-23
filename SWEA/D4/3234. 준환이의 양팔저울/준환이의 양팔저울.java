import java.io.*;
import java.util.*;

public class Solution {
	static int[] num, weight;
	static int n;
	static int answer;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=test_case; t++) {
			n = Integer.parseInt(br.readLine());
			num = new int[n];
			weight = new int[n];
			answer = 0;
			visit = new boolean[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++){
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0);
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
			
	}

	public static void solve(int count) {
		if(count == n) {
			check(0,0,0);
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			weight[count] = num[i];
			solve(count+1);
			visit[i] = false;
		}
		
	}
	public static void check(int idx, int left, int right){
		if(idx == n) {
			answer++;
			return;
		}
		check(idx+1, left+weight[idx], right);
		if(right + weight[idx] <= left)
			check(idx+1, left, right + weight[idx]);
	}
}
