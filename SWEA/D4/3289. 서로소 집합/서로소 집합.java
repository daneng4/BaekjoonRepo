import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
        	StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        	arr = new int[n+1];
        	
            makeSet();
            
            for(int i = 0; i<m; i++) {
            	st = new StringTokenizer(br.readLine());
            	int op = Integer.parseInt(st.nextToken());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	
            	if(op == 1) {
            		int pA = findSet(a);
            		int pB = findSet(b);
            		
            		if(pA == pB)
            			sb.append(1);
            		else
            			sb.append(0);
            	}else 
            		unionSet(a,b);
            }
        	
            bw.write(String.format("#%d %s\n", tc, sb.toString()));
        }// tc
        bw.flush();
    }
    public static void makeSet() {
    	for(int i = 1; i<=n; i++) {
    		arr[i] = i;
    	}
    }
    public static int findSet(int x) {
    	if(arr[x] == x)
    		return x;
    	return arr[x] = findSet(arr[x]);
    }
    public static void unionSet(int a, int b) {
    	int aP = findSet(a);
    	int bP = findSet(b);
    	
    	if(aP != bP)
    		arr[bP] = aP;
    }
}