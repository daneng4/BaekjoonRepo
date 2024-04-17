
import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Set<String> set;
	static String[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			map = new String[4][4];
			set = new HashSet<>();
			
			for(int i = 0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<4; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					bfs(i,j);
				}
			}
			
			bw.write(String.format("#%d %d\n", test_case, set.size()));
		} // end of testcase
		bw.flush();
	}
	public static void bfs(int x, int y) {
		Queue<num> q = new LinkedList<>();
		q.add(new num(x, y, "", 0));
		
		while(!q.isEmpty()) {
			num poll = q.poll();
			int curx = poll.x; 
			int cury = poll.y;
			
			// 자릿수가 7이라면
			if(poll.curLen == 7) {
				set.add(poll.curStr);
				continue;
			}
			
			for(int i = 0; i<4; i++) {
				int nextx = curx + dx[i];
				int nexty = cury + dy[i];
				
				if(nextx < 0 || nextx > 3 || nexty < 0 || nexty > 3)
					continue;
				
				q.add(new num(nextx, nexty, poll.curStr.concat(map[nextx][nexty]), poll.curLen+1));
			}
		}
		
	}
}
class num {
	int x;
	int y;
	String curStr;
	int curLen;
	public num(int x, int y, String curStr, int curLen) {
		this.x = x;
		this.y = y;
		this.curStr = curStr;
		this.curLen = curLen;
	}
}