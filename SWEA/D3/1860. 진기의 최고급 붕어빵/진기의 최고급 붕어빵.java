
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] customer = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				customer[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(customer);
			
			int total = 0; // 총 붕어빵의 개수
			int idx = 0; // 손님 도착시간 idx
			boolean isPossible = true; // 붕어빵을 바로 제공할수있는가 여부
			for(int i = 0; i<=customer[customer.length-1]; i++) {
				// 붕어빵이 만들어지는 시간
				if(i > 0 && i % m == 0) {
					total += k;
				}
				// 손님 도착
				if(i == customer[idx]) {
					// 붕어빵이 없다면
					if(total - 1 < 0) {
						isPossible = false;
						break;
					}else {
						total -= 1;
						idx++;
					}
				}
			}
			if(!isPossible)
				bw.write(String.format("#%d %s\n", t, "Impossible"));
			else
				bw.write(String.format("#%d %s\n", t, "Possible"));
			
		}// end of tc
		bw.flush();
	}
}
