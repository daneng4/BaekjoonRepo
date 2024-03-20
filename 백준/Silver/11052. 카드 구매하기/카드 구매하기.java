
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n+1];
		int[] dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카드 n개를 구매 할때 최대 비용
		// 카드 개수는 card 배열의 인덱스, 배열의 값이 i장당 가격을 의미

		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
			}
		}
		
		System.out.println(dp[n]);
		
	}

}




