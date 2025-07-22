import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] sum = new long[m+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i<=m; i++) {
        	sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i<=n; i++) {
        	long want = Long.parseLong(br.readLine());
        	int idx = Arrays.binarySearch(sum, want);
        	int answer;
        	if(idx > 0)
        		answer = idx;
        	else
        		answer = -(idx+1);
        	
        	if(answer > m)
        		sb.append("Go away!\n");
        	else
        		sb.append(answer).append('\n');
        }
        
        System.out.println(sb);
    }
}