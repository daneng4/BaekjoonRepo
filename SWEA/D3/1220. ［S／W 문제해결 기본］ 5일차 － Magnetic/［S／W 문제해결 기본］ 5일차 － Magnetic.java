import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = 10;
		int[][] map;
		
		for(int t = 1; t<=test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new int[n][n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for(int i = 0; i<n; i++) {
				int last = 0;
				for(int j = 0; j<n; j++) {
					if(map[j][i] == 1)
						last = 1;
					else if(map[j][i] == 2) {
						if(last == 1) {
							count++;
						}
						last = 2;
					}
				}
			}
			bw.write(String.format("#%d %d\n",t, count));
		}
		bw.flush();
			
	}
}
