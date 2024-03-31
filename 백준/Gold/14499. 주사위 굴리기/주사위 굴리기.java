
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int[][] map;
	static int[] d;
	static int[] dx = {0,0,0,-1,1}; // 1=동, 2=서, 3=북, 4=남
	static int[] dy = {0,1,-1,0,0};
	static int x,y,n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		d = new int[7];
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<k; i++) {
			int direct = Integer.parseInt(st.nextToken());
			move(direct);
		}
		System.out.println(sb);
	}
	public static void move(int direct) {
		int nextX = x+dx[direct];
		int nextY = y+dy[direct];
		
		if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
			return;
		
		changeTop(direct, nextX, nextY);
		x = nextX; y = nextY;
	}
	public static void changeTop(int direct, int x, int y) {
		int temp = d[3]; // 주사위 윗면
		
		// 이동 방향이 동쪽이라면
		if(direct == 1) {
			d[3] = d[2];
			d[2] = d[6];
			d[6] = d[4];
			d[4] = temp;
		} // 서쪽이라면
		else if(direct == 2) {
			d[3] = d[4];
			d[4] = d[6];
			d[6] = d[2];
			d[2] = temp;
		} // 북쪽이라면
		else if(direct == 3) {
			d[3] = d[5];
			d[5] = d[6];
			d[6] = d[1];
			d[1] = temp;
		} // 남쪽이라면
		else if(direct == 4) {
			d[3] = d[1];
			d[1] = d[6];
			d[6] = d[5];
			d[5] = temp;
		}
		if(map[x][y] == 0)
			map[x][y] = d[6];
		else {
			d[6] = map[x][y];
			map[x][y] = 0;
		}
		sb.append(d[3]).append("\n");
	}
}