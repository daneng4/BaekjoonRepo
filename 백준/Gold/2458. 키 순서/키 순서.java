import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	boolean[][] taller = new boolean[N+1][N+1];
    	
    	for(int i = 0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		taller[a][b] = true;
    	}
    	
    	for(int k = 1; k<=N; k++) {
    		for(int i = 1; i<=N; i++) {
    			for(int j = 1; j<=N; j++) {
    				if(taller[i][k] && taller[k][j]) {
    					taller[i][j] = true;
    				}
    			}
    		}
    	}
    	
    	int answer = 0;
    	for(int i = 1; i<=N; i++) {
    		int count = 0;
    		
    		for(int j = 1; j<=N; j++) {
    			if(taller[i][j] || taller[j][i])
    				count++;
    		}
    		
    		if(count == N-1)
    			answer++;
    	}
    	
    	System.out.println(answer);
    }
}