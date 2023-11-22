
import java.io.*;
import java.util.*;

public class Main {

	public static boolean[][] map;
	public static int n;
	public static final boolean white = true;
	public static final boolean blue = false;
	public static int wCount = 0;
	public static int bCount = 0;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1)
					map[i][j] = blue;
				else
					map[i][j] = white;
			}
		}

		solve(0, 0, n);
		System.out.println(wCount);
		System.out.println(bCount);
	}
	public static void solve(int row, int col, int size) {
		
		if(colorCheck(row, col, size)) {
			if(map[row][col] == white) {
				wCount++;
			}else {
				bCount++;
			}
			return;
		}else {
			size = size / 2;
			solve(row, col, size);
			solve(row+size, col, size);
			solve(row, col+size, size);
			solve(row+size, col+size, size);
		}
	}
	public static boolean colorCheck(int row, int col, int size) {
		boolean color = map[row][col];
		for(int i = row; i<row + size; i++) {
			for(int j = col; j<col + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
	
}
