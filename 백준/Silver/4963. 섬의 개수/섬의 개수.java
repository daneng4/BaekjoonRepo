import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int w, h;
	static int[] dx = {1,0,-1,0,-1,1,-1,1};
	static int[] dy = {0,1,0,-1,-1,1,1,-1};
	static int[][] map;
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	while(true) {
    		st = new StringTokenizer(br.readLine());
    		
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		if(w == 0 && h == 0)
    			break;
    		
    		map = new int[h][w];
    		boolean[][] visit = new boolean[h][w];
    		for(int i = 0; i<h; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<w; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		int total = 0;
    		for(int i = 0; i<h; i++) {
    			for(int j = 0; j<w; j++) {
    				if(map[i][j] == 1 && !visit[i][j]) {
    					bfs(i, j, visit);				
    					total += 1;
    				}
    			}
    		}
    		
    		sb.append(total + "\n");
    	}
    	
    	System.out.println(sb.toString());
	}
	public static void bfs(int hvalue, int wvalue, boolean[][] visit) {
		Queue<int[]> q = new LinkedList<>();
		visit[hvalue][wvalue] = true;
		q.add(new int[] {hvalue, wvalue});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int curh = poll[0];
			int curw = poll[1];
			
			for(int i = 0; i<8; i++) {
				int nexth = curh + dx[i];
				int nextw = curw + dy[i];
				
				if(nexth < 0 || nextw < 0 || nexth >= h || nextw >= w) 
					continue;
				if(visit[nexth][nextw] || map[nexth][nextw] == 0)
					continue;
				q.add(new int[] {nexth, nextw});
				visit[nexth][nextw] = true;
			}
		}
	}
}