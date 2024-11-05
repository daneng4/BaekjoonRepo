import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long cash = Long.parseLong(st.nextToken());
		long coin = 0;
		int[] p = new int[n];
		
		for(int i = 0; i<n; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i<n-1; i++) {
			if(coin == 0 && p[i] < p[i+1]) {
				coin = cash / p[i];
				cash -= coin * p[i];
			}
			
			if(p[i] > p[i+1]) {
				cash += coin * p[i];
				coin = 0;
			}
		}
		
		cash += coin * p[p.length-1];
		System.out.println(cash);
	}
}