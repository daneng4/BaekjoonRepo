import java.io.*;
import java.util.*;

public class Main {
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static int[][] map;
	private static int num;
	private static int x, y, m;
	private static int targetx, targety;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		// 이전 x,y
		x = n/2; 
		y = n/2;
		
		targetx = x+1;
		targety = y+1;
		
		// 방향벡터 인덱스
		int direction = 0;
		
		// 방향벡터 이동 횟수
		int count = 1;
		num = 1;
		
		map[x][y] = num;
		
		while(true) {
			for(int i = 0; i<count; i++) {
				move(direction);
				if(num == Math.pow(n, 2)) {
					for(int j = 0; j<n; j++) {
						for(int k = 0; k<n; k++) {
							sb.append(map[j][k] + " ");
						}
						sb.append("\n");
					}
					sb.append(targetx + " " + targety);
					System.out.println(sb.toString());
					return;
				}
			}
			
			if(direction % 2 == 1)
				count += 1;
			direction = (direction + 1) % 4;
		}
	}
	private static void move(int direction) {
		switch (direction) {
			case UP : {
				map[--x][y] = ++num;
				break;
			}
			case RIGHT : {
				map[x][++y] = ++num;
				break;
			}
			case DOWN : {
				map[++x][y] = ++num;
				break;
			}
			case LEFT : {
				map[x][--y] = ++num;
				break;
			}
		}
		
		if(num == m) {
			targetx = x+1;
			targety = y+1;
		}
	}
}