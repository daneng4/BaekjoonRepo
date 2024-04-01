
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int[][] map;
	static int[] answer;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		answer = new int[3]; // 0 => 0, 1 => 1, 2 => -1
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(1, 1, n);
		System.out.println(answer[2]);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
	public static void search(int row, int col, int size) {
		if(check(row, col, size)) {
			if(map[row][col] == -1) {
				answer[2] ++;
			}else if(map[row][col] == 0) {
				answer[0] ++;
			}else {
				answer[1] ++;
			}
			return;
		}
		
		int div = size/3;
		
		search(row, col, div);
		search(row, col+div, div);
		search(row, col+div*2, div);
		
		search(row+div, col, div);
		search(row+div, col+div, div);
		search(row+div, col+div*2, div);
		
		search(row+div*2, col, div);
		search(row+div*2, col+div, div);
		search(row+div*2, col+div*2, div);
		
	}
	public static boolean check(int row, int col, int size) {
		int element = map[row][col];
		
		for(int i = row; i<row+size; i++) {
			for(int j = col; j<col+size; j++) {
				if(map[i][j] != element)
					return false;
			}
		}
		return true;
	}
}