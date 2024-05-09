import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] visit;
	static int answer;
	static int answerstart;
	static Queue<int[]> memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = 10;
		
		for(int t = 1; t<=test_case; t++) {
			int testnumber = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visit = new boolean[100][100];
			memo = new LinkedList<>();
			Queue<int[]> start = new LinkedList<>();
			
			for(int i = 0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 && map[i][j] == 1) {
						start.add(new int[] {i,j});
					}
				}
			}
			
			answer = Integer.MAX_VALUE;
			answerstart = 0;
			
			while(!start.isEmpty()) {
				int[] poll = start.poll();
				solve(poll[0], poll[1]);
				initVisit();
			}
			
			bw.write(String.format("#%d %d\n", testnumber, answerstart));
		} // testcase
		bw.flush();
			
	}
	public static void solve(int x, int y) {
		int curx = x; int cury = y;
		visit[curx][cury] = true;
		int count = 1;
		
		while(curx != 99) {
			// 출발 지점에서 한 칸 내려가야함
			if(curx == 0) {
				curx++;
				count++;
				visit[curx][cury] = true;
				memo.add(new int[] {curx, cury});
				continue;
			}
			// 현재 위치 양 옆에 길이 있는지 확인
			else {
				if(checkLeft(curx, cury-1)) {
					cury--;
					count++;
					visit[curx][cury] = true;
					memo.add(new int[] {curx, cury});
					continue;
				}else if(checkRight(curx, cury+1)) {
					cury++;
					count++;
					visit[curx][cury] = true;
					memo.add(new int[] {curx, cury});
					continue;
				}else {
					curx++;
					count++;
					visit[curx][cury] = true;
					memo.add(new int[] {curx, cury});
				}
			}
		}
		
		if(count < answer) {
			answer = count;
			answerstart = y;
		}else if(count == answer) {
			answerstart = Math.max(answerstart, y);
		}
	}
	public static boolean checkLeft(int x, int y) {
		// 맵밖에 벗어나면 안되고 방문한 곳이면 안됨
		if(y < 0 || y > 99)
			return false;
		else if(visit[x][y])
			return false;
		if(map[x][y] == 1)
			return true;
		else
			return false;
	}
	public static boolean checkRight(int x, int y) {
		// 맵밖에 벗어나면 안되고 방문한 곳이면 안됨
		if(y < 0 || y > 99)
			return false;
		else if(visit[x][y])
			return false;
		if(map[x][y] == 1)
			return true;
		else
			return false;
	}
	public static void initVisit() {
		while(!memo.isEmpty()) {
			int[] poll = memo.poll();
			int x = poll[0]; int y = poll[1];
			visit[x][y] = false;
		}
	}
}
