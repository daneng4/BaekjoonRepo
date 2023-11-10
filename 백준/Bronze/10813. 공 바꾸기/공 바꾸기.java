
import java.io.*;
import java.util.*;


public class Main {
	
	
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] basket = new int[n+1];
		
		for(int t = 1; t<=n; t++) {
			basket[t] = t;
		}
		
		for(int t = 1; t<=m; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int temp = basket[i];
			basket[i] = basket[j];
			basket[j] = temp;	
		}
		
		for(int t = 1; t<=n; t++) {
			System.out.print(basket[t] + " ");
		}
	}
}
