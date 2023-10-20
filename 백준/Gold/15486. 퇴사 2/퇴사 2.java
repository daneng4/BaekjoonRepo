import java.util.*;
import java.io.*;

public class Main {

	public static int[][] work;
	public static int[] priceSum;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		work = new int[n+2][2];
		priceSum = new int[n+2];
		StringTokenizer st;
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			work[i][0] = date;
			work[i][1] = price;
		}

		int max = -1;
		for(int i = 1; i<=n+1; i++) {
			if(max < priceSum[i]) {
				max = priceSum[i];
			}
			
			int nextDate = i + work[i][0];
			if(nextDate < n+2)
				priceSum[nextDate] = Math.max(priceSum[nextDate], max + work[i][1]);
		}
		System.out.println(priceSum[n+1]);
	}
}
