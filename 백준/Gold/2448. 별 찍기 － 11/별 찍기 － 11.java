import java.io.*;
import java.util.*;

public class Main {
	private static char[][] stars;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		stars = new char[n][n * 2 - 1];
		
		for(int i = 0; i<n; i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		star(0, n-1, n);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n ;i++) {
			for(int j = 0; j<2*n-1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void star(int r, int c, int n) {
		if(n == 3) {
			stars[r][c] = '*';
			stars[r+1][c-1] = stars[r+1][c+1] = '*';
			stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
			return;
		}
		int cut = n/2;
		star(r,c,cut);
		star(r + cut, c - cut, cut);
		star(r + cut, c + cut, cut);
	}
}