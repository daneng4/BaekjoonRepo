import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=t; test++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i = -n; i<=n; i++) {
				for(int j = -n; j<=n; j++) {
					if(i*i + j*j <= n*n)
						count++;
				}
			}
			bw.write(String.format("#%d %d\n", test, count));
		}
		bw.flush();
	}

}