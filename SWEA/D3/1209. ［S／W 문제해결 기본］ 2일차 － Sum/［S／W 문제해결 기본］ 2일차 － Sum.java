import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int testcase = 10;
		
		for(int tc = 1; tc<=testcase; tc++) {
			int testNumber = Integer.parseInt(br.readLine());
			map = new int[100][100];
			max = 0;
			
			for(int i = 0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<100; i++) {
				getRowMax(i);
			}
			for(int i = 0; i<100; i++) {
				getColMax(i);
			}
			
			getDaegakMax(0,0);
			getReverseDaegakMax(99,99);
			bw.write(String.format("#%d %d\n", testNumber, max));
		}
		bw.flush();
		bw.close();
	}
	static void getRowMax(int row) {
		int sum = 0;
		for(int i = 0; i<100; i++) {
			sum += map[row][i];
		}
		max = Math.max(max, sum);
	}
	static void getColMax(int col) {
		int sum = 0;
		for(int i = 0; i<100; i++) {
			sum += map[i][col];
		}
		max = Math.max(max, sum);
	}
	static void getDaegakMax(int x, int y) {
		int sum = 0;
		for(int i = 0; i<100; i++) {
			sum += map[x+i][y+i];
		}
		max = Math.max(max, sum);
	}
	static void getReverseDaegakMax(int x, int y) {
		int sum = 0;
		for(int i = 0; i<100; i++) {
			sum += map[x-i][y-i];
		}
		max = Math.max(max, sum);
	}
}
