import java.io.*;
import java.util.*;

public class Main {
	private static int count1 = 0;
	private static int count2 = 0;
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	int[][] m = new int[n+1][n+1];
    	
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<n; j++) {
    			m[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	matrixPathRecursive(m, n);
    	matrixPathDP(m, n);
    	System.out.println(count1 + " " + count2);
	}
	private static int matrixPathRecursive(int[][] m, int n) {
		return matrixPathRecRecursive(m, n, n);
	}
	private static int matrixPathRecRecursive(int[][] m, int i, int j) {
		if(i == 0 || j == 0) {
			count1 += 1;
			return 0;
		}
		else
			return m[i][j] + Math.max(matrixPathRecRecursive(m, i-1, j), matrixPathRecRecursive(m, i, j-1));
	}
	private static int matrixPathDP(int[][] m, int n) {
		for(int i = 0; i<=n; i++) {
			m[i][0] = 0;
		}
		
		for(int j = 1; j<=n; j++) {
			m[0][j] = 0;
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				m[i][j] = m[i-1][j-1] + Math.max(m[i-1][j], m[i][j-1]);
				count2 += 1;
			}
		}
		
		return m[n][n];
	}
}