
import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[][] worm;
	static boolean[] visit;
	static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
        	n = Integer.parseInt(br.readLine());
        	worm = new int[n][2];
        	visit = new boolean[n];
        	answer = Long.MAX_VALUE;
        	
        	for(int i = 0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		worm[i][0] = Integer.parseInt(st.nextToken());
        		worm[i][1] = Integer.parseInt(st.nextToken());
        	}
        	dfs(0,0);
        	
        	bw.write(String.format("#%d %d\n", tc, answer));
        }// tc
        bw.flush();
    }
    public static void dfs(int now, int count) {
    	if(count == n/2) {
    		long x = 0; long y = 0;
    		for(int i = 0; i<n; i++) {
    			if(visit[i]) {
    				x += worm[i][0];
    				y += worm[i][1];
    			}
    			else {
    				x -= worm[i][0];
    				y -= worm[i][1];
    			}
    		}
    		answer = Math.min(answer, x*x + y*y);
    		return;
    	}
    	
    	for(int i = now; i<n; i++) {
    		if(visit[i]) continue;
    		visit[i] = true;
    		dfs(i+1, count+1);
    		visit[i] = false;
    	}
    	
    }
}

