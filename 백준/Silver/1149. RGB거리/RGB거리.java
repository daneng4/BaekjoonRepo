
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] home = new int[n+1][3];
		
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			home[i][0] = Math.min(home[i - 1][1], home[i - 1][2]) + r;
            home[i][1] = Math.min(home[i - 1][0], home[i - 1][2]) + g;
            home[i][2] = Math.min(home[i - 1][0], home[i - 1][1]) + b;
		}
		
		System.out.println(Math.min(home[n][0], Math.min(home[n][1], home[n][2])));
	}
}