import java.io.*;
import java.util.*;

public class Main {
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int[][] ddx = {{1,1},{-1,-1},{-1,1},{-1,1}};
	private static int[][] ddy = {{-1,1},{-1,1},{1,1},{-1,-1}};
	private static boolean[][] visit;
	private static int l;
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	while(n-- > 0) {
    		l = Integer.parseInt(br.readLine());
    		visit = new boolean[l][l];
    		
    		st = new StringTokenizer(br.readLine());
    		int sx = Integer.parseInt(st.nextToken());
    		int sy = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		int ex = Integer.parseInt(st.nextToken());
    		int ey = Integer.parseInt(st.nextToken());
    		
    		int answer = process(sx, sy, ex, ey);
    		sb.append(answer + "\n");
    	}
    	
    	System.out.println(sb.toString());
	}
	private static int process(int sx, int sy, int ex, int ey) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(sx, sy, 0));
		visit[sx][sy] = true;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			Info poll = q.poll();
			int nowx = poll.x;
			int nowy = poll.y;
			int curCount = poll.count;
			
			if(nowx == ex && nowy == ey) {
				min = Math.min(min, curCount);
			}
			
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<2; j++) {
					int[] next = move(nowx, nowy, i, j);
					int nextx = next[0]; int nexty = next[1];
					
					if(nextx < 0 || nextx >= l || nexty < 0 || nexty >= l)
						continue;
					if(visit[nextx][nexty])
						continue;
					
					q.add(new Info(nextx, nexty, poll.count + 1));
					visit[nextx][nexty] = true;
				}
			}
		}
		return min;
	}
	private static int[] move(int nowx, int nowy, int i, int j) {
		int nextx = nowx + dx[i] + ddx[i][j];
		int nexty = nowy + dy[i] + ddy[i][j];
		
		return new int[] {nextx, nexty};
	}
}
class Info{
	int x;
	int y;
	int count;
	public Info(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}