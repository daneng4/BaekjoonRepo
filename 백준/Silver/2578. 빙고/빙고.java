
import java.io.*;
import java.util.*;


public class Main {
	
	public static int[][] map;
	public static int[][] bingo;
	static int matchCount = 1;
	static int bingoCount;
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		bingo = new int[5][5];
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				int dealer = Integer.parseInt(st.nextToken());
				
				findEqual(dealer);
				checkBingo();
				checkDaegak1();
				checkDaegak2();
				
				if(bingoCount >= 3) {
					System.out.println(matchCount);
					System.exit(0);
				}
				matchCount+=1;
				bingoCount = 0;
			}
		}
		
	}
	public static void checkBingo() {
		for(int i = 0; i<5; i++) {
			int count = 0;
			for(int j = 0; j<5; j++) {
				if(bingo[i][j] == 1) {
					count++;
				}
				if(count == 5) {
					bingoCount++;
				}
			}
		}
		for(int i = 0; i<5; i++) {
			int count = 0;
			for(int j = 0; j<5; j++) {
				if(bingo[j][i] == 1) {
					count++;
				}
				if(count == 5) {
					bingoCount++;
				}
			}
		}
	}
	public static void checkDaegak1() {
		int count = 0;
		for(int i = 0; i<5; i++) {
			if(bingo[i][i] == 1) {
				count++;
			}
			if(count == 5) {
				bingoCount++;
			}
		}
	}
	public static void checkDaegak2() {
		int count = 0;
		for(int i = 0; i<5; i++) {
			if(bingo[i][4-i] == 1) {
				count++;
			}
			if(count == 5) {
				bingoCount++;
			}
		}
	}
	public static void findEqual(int dealer) {
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				if(map[i][j] == dealer)
					bingo[i][j] = 1;
			}
		}
	}
}
