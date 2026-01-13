
import java.io.*;
import java.util.*;

public class Main {
	static Set<Integer> row = new HashSet<>();
    static Set<Integer> col = new HashSet<>();
    static Set<Integer> diag1 = new HashSet<>(); // r - c
    static Set<Integer> diag2 = new HashSet<>(); // r + c
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			row.add(r);
			col.add(c);
			diag1.add(r-c);
			diag2.add(r+c);
		}
		
		boolean attacked = isAttacked(R, C);
		
		boolean isSafe = false;
		
		for(int i = 0; i<8; i++) {
			int nx = R + dx[i];
			int ny = C + dy[i];
			
			if(nx < 1 || ny < 1 || nx > N || ny > N)
				continue;
			
			if(!isAttacked(nx, ny)) {
				isSafe = true;
				break;
			}
		}
		
		if(attacked && isSafe) {
			System.out.println("CHECK");
		}else if(!attacked && !isSafe) {
			System.out.println("STALEMATE");
		}else if(attacked && !isSafe) {
			System.out.println("CHECKMATE");
		}else {
			System.out.println("NONE");
		}
		
	}
	public static boolean isAttacked(int r, int c) {
		return row.contains(r) || col.contains(c) || diag1.contains(r-c) || diag2.contains(r+c);
	}
}