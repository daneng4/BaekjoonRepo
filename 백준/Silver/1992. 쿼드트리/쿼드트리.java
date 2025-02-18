import java.io.*;
import java.util.*;

public class Main {
	private static int[][] map;
	private static int n;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		process(0, 0, n);
		System.out.println(sb.toString());
	}
	private static void process(int x, int y, int size) {
		// 해당 영역의 숫자들이 전부 같다면
		if(find(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		
		int newSize = size / 2;
		sb.append("(");

		process(x, y, newSize);
		process(x, y+newSize, newSize);
		process(x + newSize, y, newSize);
		process(x + newSize, y + newSize, newSize);
		
		sb.append(")");
	}
	private static boolean find(int x, int y, int size) {
		int first = map[x][y];
		for(int i = x; i<x + size; i++) {
			for(int j = y; j<y + size; j++) {
				if(map[i][j] != first)
					return false;
			}
		}
		
		return true;
	}
}