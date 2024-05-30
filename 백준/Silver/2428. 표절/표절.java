import java.util.*;
import java.io.*;

public class Main {
	static int[] files;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		files = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			files[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(files);
		
		long answer = 0;
		// 이분탐색으로 i의 90%인 수보다 크거나 같은 최소 수를 구함.
		for(int i = n-1; i>=1; i--) {
			int found = bs(i); // files[found] 보다 큰 수는 전부 검사 대상임
			answer += i - found;
		}
		
		System.out.println(answer);
	}
	public static int bs(int idx) {
		int start = 0;
		int end = idx;
		
		double target = (files[idx] * 0.9);
		int result = 0;
		
		while(start<=end) {
			int mid = (start + end) / 2;
			
			if(target > files[mid]) {
				start = mid + 1;
			}else {
				result = mid;
				end = mid - 1;
			}
		}
		
		return result;
	}
}