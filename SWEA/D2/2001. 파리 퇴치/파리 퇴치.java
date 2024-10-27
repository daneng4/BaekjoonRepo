import java.util.*;
import java.io.*;

public class Solution {
	static int[][] arr;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int i = 0; i<n-m+1; i++) {
				for(int j = 0; j<n-m+1; j++) {
					max = Math.max(max, cal(i,j));
				}
			}
			
			bw.write(String.format("#%d %d\n", tc, max));
		}
		bw.flush();
		bw.close();
	}
	static int cal(int x, int y) {
		int sum = 0;
		for(int i = x; i<x+m; i++) {
			for(int j = y; j<y+m; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
}