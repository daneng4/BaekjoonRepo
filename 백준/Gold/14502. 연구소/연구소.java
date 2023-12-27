
import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m;
	public static int[][] map, clone;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setWall(0);
		
		System.out.println(max);
	}
	public static void setWall(int count) {
		if(count == 3) {
			setVirus();
			return;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					setWall(count+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	public static void setVirus() {
		Queue<Node> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 2) {
					q.add(new Node(i,j));
				}
			}
		}
		
		int[][] clone = new int[n][m];
		for(int i = 0; i<n; i++) {
			clone[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; 
            int y = now.y; 

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(clone[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        clone[nx][ny] = 2;
                    }
                }
            }
        }
		
		findSafeZone(clone);
	}
	
	public static void findSafeZone(int[][] clone) {
		int safe = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(clone[i][j] == 0)
					safe++;
			}
		}
		if(max < safe) {
			max = safe;
		}
	}

	static class Node {
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

