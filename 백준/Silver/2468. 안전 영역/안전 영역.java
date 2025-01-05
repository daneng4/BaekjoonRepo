
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int n;
	static int answer = 1;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	
    	int minH = Integer.MAX_VALUE;
    	int maxH = 0;
    	
    	for(int i = 0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			minH = Math.min(minH, map[i][j]);
    			maxH = Math.max(maxH, map[i][j]);
    		}
    	}
    	
    	for(int i = minH; i<=maxH; i++) {
    		boolean[][] water = getSafeArea(i);
    		int count = 0;
    		
    		for(int j = 0; j<n; j++) {
    			for(int k = 0; k<n; k++) {
    				if(!water[j][k]) {
    					bfs(j,k, water);   
    					count+=1;
    				}
    			}
    		}
    		
    		answer = Math.max(answer, count);
    	}
    	
    	System.out.println(answer);
    }
    
    public static boolean[][] getSafeArea(int h) {
    	boolean[][] visit = new boolean[n][n];
    	
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			if(map[i][j] <= h)
    				visit[i][j] = true;
    		}
    	}
    	
    	return visit;
    }
    
    public static void bfs(int x, int y, boolean[][] water) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	water[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int curx = cur[0]; 
    		int cury = cur[1];
    		
    		for(int i = 0; i<4; i++) {
    			int nextx = curx + dx[i];
    			int nexty = cury + dy[i];
    			
    			if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n)
    				continue;
    			if(water[nextx][nexty])
    				continue;
    			
    			q.add(new int[] {nextx, nexty});
    			water[nextx][nexty] = true;
    		}
    	}
    	
    }
}