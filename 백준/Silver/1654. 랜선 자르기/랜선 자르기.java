import java.util.*;
import java.io.*;

public class Main {
	static int[] lans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 수
		int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 수
		lans = new int[k];
		
		// 최소 개수는 최대 길이로 모든 랜선들을 나눴을 때 -> 1
		// 최대 개수는 1로 모든 랜선들을 나눴을 때

		long maxLen = 0;
		for(int i = 0; i<k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(lans[i], maxLen);
		}
		
		long start = 1;
		long end = maxLen;
		long answer = 0;
		
		while(start <= end) {
			long mid = (start + end)/2;
			// 나눈 개수
			long result = divide(mid);
			
			// 나눈 개수가 필요한 것보다 많은 것도 n개에 포함됨
			// 하지만 만들수있는 최대 랜선 길이를 구하는 것이므로
			// 최대값을 갱신하고 길이를 증가시켜서 다시 탐색
			if(result >= n) {
				answer = Math.max(answer, mid);
				start = mid+1;
			} 
			// 나눈 개수가 필요한 랜선 수 보다 적다면
			// 더 짧은 길이로 나눠야함
			else {
				end = mid-1;
			}
		}
		
		System.out.println(answer);
		
	}
	public static long divide(long mid) {
		int count = 0;
		for(int i = 0; i<lans.length; i++) {
			count += lans[i] / mid;
		}
		return count;
	}
}