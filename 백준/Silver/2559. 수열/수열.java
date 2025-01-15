
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] num = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int start = 0;
    	int end = start + k;
    	int max = Integer.MIN_VALUE;
    	while(end != num.length + 1) {
    		int temp = 0;
    		for(int i = start ; i<end; i++) {
    			temp += num[i];
    		}
    		max = Math.max(max, temp);
    		start += 1;
    		end = start + k;
    	}
    	
    	System.out.println(max);
	}
}