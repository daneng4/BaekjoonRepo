
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	dfs(arr, 0, "", 0);
    	
    	System.out.println(sb.toString());
    }
    public static void dfs(int[] arr, int len, String str, int pre) {
    	if(len == m) {
    		sb.append(str + "\n");
    		return;
    	}
    	
    	for(int i = pre; i<arr.length; i++) {
    		if(len == 0)
    			dfs(arr, len + 1, str + arr[i], i);
    		else
    			dfs(arr, len + 1, str + " " + arr[i], i);
    	}
    	
    	
    }
}