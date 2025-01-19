import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[n][m];
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<m; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<m; j++) {
    			arr[i][j] += Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i<n; i++) {
    		if(i != 0)
    			sb.append("\n");
    		for(int j = 0; j<m; j++) {
    			sb.append(arr[i][j] + " ");
    		}
    	}
    	
    	System.out.println(sb.toString());
	}
}