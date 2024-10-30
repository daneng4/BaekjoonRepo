import java.io.*;
import java.util.*;

public class Solution {
	static int n, k;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n+2][n+2];
			int answer = 0;
			
			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(arr[i][j] == 1)  {
						if(arr[i][j-1] == 0)
							answer += countRight(i, j);
						if(arr[i-1][j] == 0)  
							answer += countDown(i, j);
					}
				}
			}
			
			bw.write(String.format("#%d %d\n", tc, answer));
		}
		bw.flush();
		bw.close();
	}
	static int countRight(int x, int y) {
		int count = 1;
		while(true) {
			y+=1;
			if(arr[x][y] == 0)
				break;
			count++;
		}
		if(count == k)
			return 1;
		else
			return 0;
	}
	static int countDown(int x, int y) {
		int count = 1;
		while(true) {
			x+=1;
			if(arr[x][y] == 0)
				break;
			count++;
		}
		if(count == k)
			return 1;
		else
			return 0;
	}
}
