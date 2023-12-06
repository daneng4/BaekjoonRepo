
import java.io.*;
import java.util.*;

public class Main {
	static int[][][] box;
	static int m,n,h;
	static ArrayList<Tomato> list = new ArrayList<>();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1)
						list.add(new Tomato(i, j, k));
				}
			}
		}
		
		int result = bfs() - 1;
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<m; k++) {
					if(box[i][j][k] == 0) {
						result = -1;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
	
	public static int bfs() {
		int z = 0;
		int x = 0;
		int y = 0;
		int[] dz = {-1, 0, 0, 0, 0, 1};
		int[] dx = {0, -1, 1, 0, 0, 0};
		int[] dy = {0, 0, 0, -1, 1, 0};
		
		Queue<Tomato> q = new LinkedList<>();
		for(int i = 0; i<list.size(); i++) { // 초기 익은 토마토들
			q.offer(list.get(i));
		}
		
		while(!q.isEmpty()) {
			Tomato tomato = q.poll();
			z = tomato.getZ();
			x = tomato.getX();
			y = tomato.getY();
			
			for(int i = 0; i<6; i++) {
				int nz = z + dz[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= n || ny >= m || nz >= h || nx < 0 || ny < 0 || nz < 0) {
					continue;
				}
				if (box[nz][nx][ny] == 0) {
					q.offer(new Tomato(nz,nx,ny));
					box[nz][nx][ny] = box[z][x][y] + 1;
				}
			}
		}
		return box[z][x][y];
	}
}

class Tomato{
	private int z;
	private int x;
	private int y;
	
	public Tomato(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}
