
import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] mine;
	static String[][] gameProgress;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		mine = new boolean[n+2][n+2];
		gameProgress = new String[n][n];
		
		for(int i = 1; i<=n; i++) {
			String[] mapInfo = br.readLine().split("");
			for(int j = 1; j<=n; j++) {
				if(mapInfo[j-1].equals("*"))
					mine[i][j] = true;
				gameProgress[i-1][j-1] = ".";
			}
		}
		
		for(int i = 1; i<=n; i++) {
			String[] gameInfo = br.readLine().split("");
			for(int j = 1; j<=n; j++) {
				if(gameInfo[j-1].equals("x")) {
					// 게임 진행이 x고 지뢰가 없는 곳일경우
					if(!mine[i][j]) {
						gameProgress[i-1][j-1] = Integer.toString(searchMines(i,j));
					}
					// 게임 진행이 x고 지뢰가 있는 곳 인경우
					else {
						gameProgress[i-1][j-1] = "*";
						findAllMines();
					}
				} 
			}
		}
		print();
	}
	public static int searchMines(int i, int j) {
		
		// 현재 i,j 좌표를 둘러싼 좌표 중 지뢰가 있는지 탐색
		int startX = i-1;
		int startY = j-1;
		int count = 0;
		
		for(int k = 0; k<=2; k++) {
			if(mine[startX][startY+k]) 
				count++;
		}
		
		if(mine[i][j-1]) {
			count++;
		}
		if(mine[i][j+1]) {
			count++;
		}
		startX = i+1;
		startY = j-1;
		
		for(int k = 0; k<=2; k++) {
			if(mine[startX][startY+k])
				count++;
		}

		return count;
	}
	public static void findAllMines() {
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(mine[i][j])
					gameProgress[i-1][j-1] = "*";
			}
		}		
	}
	public static void print() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(gameProgress[i][j]);
			}
			System.out.println();
		}
	}
}
