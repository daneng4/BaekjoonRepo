import java.io.*;
import java.util.*;

public class Solution {
	static int[][] work;
	static int n;
	static boolean[] visit;
	static double answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= t; tc++) {
			n = Integer.parseInt(br.readLine());
			work = new int[n][n];
			visit = new boolean[n];
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					work[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			dfs(100, 0);
			
			bw.write(String.format("#%d %.6f\n", tc, answer));
		} // tc
		bw.flush();
	}
	public static void dfs(double sum, int depth) {
		if(answer >= sum)
			return;
		if(depth == n) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i = 0; i<n; i++) {
				if(visit[i])
					continue;
				visit[i] = true;
				dfs(sum * work[depth][i] * 0.01, depth+1);
				visit[i] = false;
			}
		}
	
}
