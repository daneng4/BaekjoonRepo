
import java.io.*;
import java.util.*;

public class Main {
	public static int[][] map;
	public static int see, n, m;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[n][m];
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		see = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r,c);
		System.out.println(count);
	}
	public static void clean(int r, int c) {
		int curx = r;
		int cury = c;
		
		while(true) {
			// 먼저 현재 좌표가 청소해야 하는 곳인지 체크
			if(map[curx][cury] == 0) {
				map[curx][cury] = 2;
			}
			// 현재 좌표에서 상하좌우에 청소해야하는 곳이 있는지 체크
			// 0 = 북, 1 = 동, 2 = 남, 3 = 서
			for(int i = 0; i<4; i++) {
				if(see == 0) { // 현재 보는 곳이 북쪽이면
					see = 3;
					cury -= 1;
					if(map[curx][cury] == 0) {
						break;
					}else { // 바라본 곳이 청소할 곳이 아니면
						cury+=1;
					}
				}else if(see == 1) { // 현재 보는 곳이 동쪽이면
					see = 0;
					curx-=1;
					if(map[curx][cury] == 0) {
						break;
					}else {
						curx+=1;
					}
				}else if(see == 2) { // 남쪽이라면
					see = 1;
					cury+=1;
					if(map[curx][cury] == 0) {
						break;
					}else {
						cury-=1;
					}
				}else if(see == 3){ // 서쪽이라면 
					see = 2;
					curx+=1;
					if(map[curx][cury] == 0) {
						break;
					}else {
						curx-=1;
					}
				}
			}
			
			if(curx == r && cury == c) { // 이전 좌표와 현재 좌표가 같다면 -> 청소할 곳이 없었다면
				// 뒤로 한칸 이동
				if(see == 0) {
					curx+=1;
					if(map[curx][cury] == 1)
						break;
				}else if(see == 1) {
					cury-=1;
					if(map[curx][cury] == 1)
						break;
				}else if(see == 2) {
					curx-=1;
					if(map[curx][cury] == 1)
						break;
				}else if(see == 3) {
					cury+=1;
					if(map[curx][cury] == 1)
						break;
				}
			}
			r = curx; c = cury;
		} // end of while
		
		countCleanZone();
		
	}
	public static void countCleanZone() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if (map[i][j] == 2)
					count++;
			}
		}
	}
}

