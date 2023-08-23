
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] stocks = new long[N];
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j<N; j++) {
				stocks[j] = Integer.parseInt(st.nextToken());
			}
			
			long max = 0;
			long answer = 0;
			for(int j = N-1; j>=0;j--) {
				if(stocks[j]>max) {
					max = stocks[j];
				}else {
					answer += max - stocks[j];
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
		
	}
}


