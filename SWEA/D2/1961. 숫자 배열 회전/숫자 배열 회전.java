
import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[][] map, rotate90, rotate180, rotate270;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int tc = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int t = 1; t<=tc; t++) {
    		n = Integer.parseInt(br.readLine());
    		map = new int[n][n];
    		
    		for(int i = 0; i<n; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<n; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		
    		for(int i = 0; i<3; i++) {
    			rotate90 = new int[n][n];
    			rotate180 = new int[n][n];
    			rotate270 = new int[n][n];
    			rotate90();
    			rotate180();
    			rotate270();
    		}

    		sb.append(String.format("#%d\n", t));
    		for(int i = 0; i<n; i++) {
    			for(int j = 0; j<n; j++) {
    				sb.append(rotate90[i][j]);
    			}
    			sb.append(" ");
    			for(int j = 0; j<n; j++) {
    				sb.append(rotate180[i][j]);
    			}
    			sb.append(" ");
    			for(int j = 0; j<n; j++) {
    				sb.append(rotate270[i][j]);
    			}
    			sb.append("\n");
    		}
    		
    	}// end of tc
    	System.out.println(sb);
    }
    public static void rotate90() {
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			rotate90[j][n-i-1] = map[i][j];
    		}
    	}
    	
    	// 복사
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			map[i][j] = rotate90[i][j];
    		}
    	}

    }
    public static void rotate180() {
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			rotate180[j][n-i-1] = map[i][j];
    		}
    	}
    	
    	// 복사
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			map[i][j] = rotate180[i][j];
    		}
    	}
    }
    public static void rotate270() {
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			rotate270[j][n-i-1] = map[i][j];
    		}
    	}

    }
}