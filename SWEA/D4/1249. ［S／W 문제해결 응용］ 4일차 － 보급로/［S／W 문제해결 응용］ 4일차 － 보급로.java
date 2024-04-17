
import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int min;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int tc = Integer.parseInt(br.readLine());
    	
    	for(int t = 1; t<=tc; t++) {
    		n = Integer.parseInt(br.readLine());
    		map = new int[n][n];
    		visit = new boolean[n][n];
    		min = Integer.MAX_VALUE;
    		
    		for(int i = 0; i<n; i++) {
    			String[] str = br.readLine().split("");
    			for(int j = 0; j<n; j++) {
    				map[i][j] = Integer.parseInt(str[j]);
    			}
    		}
    		
    		bfs(0,0);
    		bw.write(String.format("#%d %d\n", t, min));
    	}// end of tc

    	bw.flush();
    }
    public static void bfs(int x, int y) {
    	PriorityQueue<Pos> pq = new PriorityQueue<>();
    	pq.add(new Pos(x, y, 0));
    	visit[x][y] = true;
    	
    	while(!pq.isEmpty()) {
    		Pos poll = pq.poll();
    		int curx = poll.x;
    		int cury = poll.y;
    		int curt = poll.time;
    		
    		if(curx == n-1 && cury == n-1) {
    			min = Math.min(min, curt);
    		}
    		
    		for(int i = 0; i<4; i++) {
    			int nextx = curx+dx[i];
    			int nexty = cury+dy[i];
    			
    			if(nextx >= n || nexty >=n || nextx < 0 || nexty < 0)
    				continue;
    			
    			if(visit[nextx][nexty])
    				continue;
    			
    			pq.add(new Pos(nextx, nexty, curt+map[nextx][nexty]));
    			visit[nextx][nexty] = true;
    		}
    		
    	}
    	
    }
}
class Pos implements Comparable<Pos>{
	int x;
	int y;
	int time;
	Pos(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.time = value;
	}
	
	public int compareTo(Pos p) {
		return time - p.time;
	}
}