import java.io.*;
import java.util.*;

public class Main {
	private static final int RIGHT = 0;
	private static final int UP = 1;
	private static final int LEFT = 2;
	private static final int DOWN = 3;
	private static boolean[][] map;
	private static final int size = 101;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		map = new boolean[size][size];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			List<Integer> directions = findDirections(d, g);
			draw(directions, x, y);
		}
		
		findSquare();
	}
	private static List<Integer> findDirections(int d, int g) {
		List<Integer> directionList = new ArrayList<>();
		directionList.add(d);
		
		for(int i = 0; i < g; i++) {
			for(int j = directionList.size() - 1; j >= 0; j--) {
				directionList.add((directionList.get(j) + 1) % 4);
			}
		}
		
		return directionList;
	}
	private static void draw(List<Integer> directions, int x, int y) {
		map[x][y] = true;
		
		for(int direction : directions) {
			switch (direction) {
				case RIGHT : {
					map[++x][y] = true;
					break;
				}
				case LEFT : {
					map[--x][y] = true;
					break;
				}
				case UP : {
					map[x][--y] = true;
					break;
				}
				case DOWN : {
					map[x][++y] = true;
					break;
				}
			}
		}
	}
	private static void findSquare() {
		int count = 0;
		
		for(int i = 0; i<size-1; i++) {
			for(int j = 0; j<size-1; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					count += 1;
				}
			}
		}
		
		System.out.println(count);
	}
}