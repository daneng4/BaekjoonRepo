import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	while(T-->0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		long n = Long.parseLong(st.nextToken());
    		long m = Long.parseLong(st.nextToken());
    		int count = 0;
    		
    		while(n != 0) {
    			n = n / 2;
    			count++;
    		}
    		
			sb.append(count + m).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}