import java.io.*;
import java.util.*;

public class Main {
	static int r,c;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for(int i = 0; i<r; i++){
			String str = br.readLine();
			for(int j = 0; j<c; j++){
				map[i][j] = str.charAt(j);
			}
		}

		dfs(0,0, 1, String.valueOf(map[0][0]));
		System.out.println(answer);
	}
	public static void dfs(int x, int y, int count, String alpha){
		answer = Math.max(answer, count);

		for(int i = 0; i<4; i++){
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;

			char nextAlpha = map[nextX][nextY];
			boolean possible = true;

			for(int j = 0; j<alpha.length(); j++){
				if(nextAlpha == alpha.charAt(j)){
					possible = false;
					break;
				}
			}

			if(possible){
				dfs(nextX, nextY, count + 1, alpha + nextAlpha);
			}
		}
	}
}
