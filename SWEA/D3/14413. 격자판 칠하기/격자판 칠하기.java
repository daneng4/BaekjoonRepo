import java.io.*;
import java.util.*;

public class Solution {
	static boolean[][] visit;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visit = new boolean[n][m];
			q = new LinkedList<>();
			
			for(int i = 0; i<n; i++) {
				String str = br.readLine();
				for(int j = 0; j<m; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == '.' || map[i][j] == '#')
						q.add(new Node(i,j,map[i][j]));
				}
			}
			if(!bfs())
				bw.write(String.format("#%d impossible\n", test));
			else
				bw.write(String.format("#%d possible\n", test));
		}
		bw.flush();
	}
	public static boolean bfs() {
		while(!q.isEmpty()) {
			Node poll = q.poll();
			int curx = poll.x;
			int cury = poll.y;
			int curColor = poll.color;
			
			if(visit[curx][cury])
				continue;
			visit[curx][cury] = true;
			
			for(int i = 0; i<4; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				
				if(nextx < 0 || nextx > n-1 || nexty < 0 || nexty > m-1)
					continue;
				if(visit[nextx][nexty])
					continue;
				
				// 색이 같으면 impossible
				if(map[nextx][nexty] == curColor){
					return false;
				}else {
					if(curColor == '#') {
						map[nextx][nexty] = '.';
						q.add(new Node(nextx, nexty, '.'));
					}
					else {
						map[nextx][nexty] = '#';
						q.add(new Node(nextx, nexty, '#'));
					}
						
				}
				
			}
		}
		return true;
	}
}

class Node{
	int x;
	int y;
	char color; // . = 흰색, # = 검은색
	Node(int x, int y, char color){
		this.x = x; this.y = y; this.color = color;
	}
}