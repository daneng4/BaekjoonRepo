import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int[][] arr = new int[9][9];
    	int max = 0;
    	int maxX = 0; int maxY = 0;
    	
    	for(int i = 0; i<9; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<9; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(max < arr[i][j]) {
    				max = Math.max(max, arr[i][j]);
    				maxX = i;
    				maxY = j;
    			}
    		}
    	}
    	maxX += 1; maxY += 1;
    	System.out.println(max);
    	System.out.println(maxX + " " + maxY);
	}
}