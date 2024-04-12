

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testCase; t++) {
			int[][] map = new int[9][9];
			
			for(int i = 0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[] number = new boolean[10];
			if(!isRightRowCol(map, number)) {
				bw.write(String.format("#%d 0\n", t));
				continue;
			}
			if(!checkBlock(map,number)) {
				bw.write(String.format("#%d 0\n", t));
				continue;
			}
			bw.write(String.format("#%d 1\n", t));
		} // testcase
		bw.flush();
	}
	public static boolean isRightRowCol(int[][] map, boolean[] number) {
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(number[map[i][j]])
					return false;
				number[map[i][j]] = true;
			}
			Arrays.fill(number, false);
		}
		Arrays.fill(number, false);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(number[map[j][i]])
					return false;
				number[map[j][i]] = true;
			}
			Arrays.fill(number, false);
		}
		
		return true;
	}
	public static boolean checkBlock(int[][] map, boolean[] number) {
		int[][] startPos = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
		
		for(int i = 0; i<startPos.length; i++) {
			for(int x = startPos[i][0]; x < startPos[i][0] + 3; x++) {
				for(int y = startPos[i][1]; y < startPos[i][1] + 3; y++) {
					if(number[map[x][y]])
						return false;
					number[map[x][y]] = true;
				}
			}
			Arrays.fill(number, false);
		}
		return true;
	}
}
