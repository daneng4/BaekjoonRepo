import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		
		
		boolean[][] map = new boolean[101][101];
		
		for(int k = 0; k<n; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i = a; i<a+10; i++) {
				for(int j = b; j<b+10; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for(int i = 1; i<=100; i++) {
			for(int j = 1; j<=100; j++) {
				if(map[i][j])
					total++;
			}
		}
		
		System.out.println(total);
	}
}