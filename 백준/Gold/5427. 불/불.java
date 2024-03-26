import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	static int count;
	static Queue<int[]> fq,sq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc<testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[m][n];
			visit = new boolean[m][n];
			count = 1;
			fq = new LinkedList<>();
			sq = new LinkedList<>();
			
			for(int i = 0; i<m; i++) {
				String minfo = br.readLine();
				for(int j = 0; j<minfo.length(); j++) {
					map[i][j] = minfo.charAt(j);
					if(map[i][j] == '@') {
						sq.add(new int[] {i,j});
						visit[i][j] = true;
					}
					else if(map[i][j] == '*') {
						fq.add(new int[] {i,j});
					}
				}
			}
			
			if(bfs()) {
				sb.append(count).append("\n");
			}else {
				sb.append("IMPOSSIBLE").append("\n");
			}
		} // testcase
		
		System.out.println(sb.toString());
		
	}
	public static boolean bfs() {
		boolean escape = false;
		int size = 0;
		
		while(!sq.isEmpty()) {
			// 불의 움직임
			size = fq.size();
			for(int k = 0; k<size; k++) {
				int[] fPos = fq.poll();
				
				for(int i = 0; i<4; i++) {
					int fnextX = fPos[0] + dx[i];
					int fnextY = fPos[1] + dy[i];
					
					if(fnextX < 0 || fnextY < 0 || fnextX >= m || fnextY >= n)
						continue;
					if(map[fnextX][fnextY] == '#' || map[fnextX][fnextY] == '*')
						continue;
					
					fq.add(new int[] {fnextX, fnextY});
					map[fnextX][fnextY] = '*';
				}
			}
			// 상근이의 움직임
			size = sq.size();
			for(int k = 0; k<size; k++) {
				int[] sPos = sq.poll();
				
				for(int i = 0; i<4; i++) {
					int snextX = sPos[0] + dx[i];
					int snextY = sPos[1] + dy[i];
					
					// 맵 밖을 벗어나면 탈출처리
					if(snextX < 0 || snextY < 0 || snextX >= m || snextY >= n) {
						escape = true;
						break;
					}
					
					// 벽이나 불로는 전진x
					if(map[snextX][snextY] == '#' || map[snextX][snextY] == '*' || visit[snextX][snextY])
						continue;
					
					sq.add(new int[] {snextX, snextY});
					visit[snextX][snextY] = true;
					map[snextX][snextY] = '@';
				}
			}
			if(escape) {
				break;
			}
			count++;
		}
		if(escape)
			return true;
		else
			return false;
		
	}
}