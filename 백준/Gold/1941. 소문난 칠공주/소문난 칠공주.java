import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
	public static char[][] map;
	public static boolean[] visit;
	public static int[] selected;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		selected = new int[7];

		for(int i = 0; i<5; i++){
			map[i] = br.readLine().toCharArray();
		}

		bt(0,0,0);

		System.out.println(answer);
	}
	public static void bt(int depth, int numY, int start){
		// Y파가 과반수 이상이 되면 칠공주가 될 수 없음
		if(numY >= 4) return;

		if(depth == 7){
			visit = new boolean[7];
			bfs();
			return;
		}

		for(int i = start; i<25; i++){
			selected[depth] = i;
			if(map[i/5][i%5] == 'Y'){
				bt(depth + 1, numY + 1, i+1);
			}else{
				bt(depth + 1, numY, i+1);
			}
		}
	}
	public static void bfs(){
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(selected[0]/5, selected[0]%5));
		visit[0] = true;
		int count = 1;

		while(!q.isEmpty()){
			Point cp = q.poll();

			for(int i = 0; i<4; i++){
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				int ni = nx * 5 + ny;

				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

				for(int j = 0; j<7; j++){
					if(!visit[j] && selected[j] == ni){
						q.add(new Point(nx, ny));
						visit[j] = true;
						count++;
					}
				}

			}
		}

		if(count == 7)
			answer++;
	}
}
