import java.io.*;
import java.util.*;

public class Solution {
	static int[] d = {-2,-1,1,2};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = 10;
		
		for(int t = 1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] h = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			for(int i = 2; i<n-2; i++) {
				result += find(h, i);
			}
			
			bw.write(String.format("#%d %d\n", t, result));
		}
		bw.flush();
	}
	public static int find(int[] h, int curIdx) {
		int value = Integer.MAX_VALUE;
		for(int i = 0; i<4; i++) {
			// 양수일 때 차의 최소 값
			if(h[curIdx] - h[curIdx + d[i]] > 0) {
				value = Math.min(value, h[curIdx] - h[curIdx + d[i]]);
			} // 차가 음수면 나보다 높은 것, 조망권 없음
			else {
				return 0;
			}
		}
		return value;
	}
}