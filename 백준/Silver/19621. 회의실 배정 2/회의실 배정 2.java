import java.io.*;
import java.util.*;

public class Main {
	static class Meeting {
		int start;
		int end;
		int size;
		public Meeting(int start, int end, int size) {
			this.start = start; this.end = end; this.size = size;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Meeting[] m = new Meeting[n+1];
		m[0] = new Meeting(0, 0, 0);
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			m[i] = new Meeting(start, end, size);
		}
		
		
		int answer = 0;
		int[] dp = new int[n+1];
		// 회의 시간이 오름 차순으로 주어질 경우
		for(int i = 1; i<=n; i++) {
			dp[i] = m[i].size;
			for(int j = 0; j<i-1; j++) {
				if(m[i].start > m[j].end) {
					dp[i] = Math.max(dp[i], dp[j] + m[i].size);
				}
			}
		}
		
		for(int i = 1; i<=n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		dp = new int[n+1];
		// 회의 시간이 내림 차순으로 주어질 경우
		for(int i = 1; i<=n; i++) {
			dp[i] = m[i].size;
			for(int j = 0; j<i-1; j++) {
				if(m[i].end < m[j].start) {
					dp[i] = Math.max(dp[i], dp[j] + m[i].size);
				}
			}
		}
		
		for(int i = 1; i<=n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}