import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int n = Integer.parseInt(br.readLine());
    	int[] arr;
    	for(int i = 0; i<n; i++) {
    		arr = new int[10];
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		for(int j = 0; j<10; j++) {
    			arr[j] = Integer.parseInt(st.nextToken());
    		}
    		
    		Arrays.sort(arr);
    		sb.append(arr[arr.length - 3] + "\n");
    	}
    	
    	System.out.println(sb.toString());
	}
}