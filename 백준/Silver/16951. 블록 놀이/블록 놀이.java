import java.util.*;
import java.io.*;

public class Main {
	static int[] tower, arr;
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 탑 개수
		k = Integer.parseInt(st.nextToken()); // 인접 탑 높이 차이
		
		tower = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			// 각 자릿수 별로 양 옆의 차이가 k가 되도록 하는 배열을 생성한다.
			if(!makeDiff(i))
				continue;
			int result = checkDiff();
			answer = Math.min(result, answer);
		}
		
		System.out.println(answer);
	}
	public static boolean makeDiff(int idx) {
		arr = new int[n];
		
		if(idx == 0) {
			arr[0] = tower[idx];
			for(int i = 1; i<n; i++) {
				arr[i] = arr[i-1] + k;
			}
			return true;
		}
		
		arr[idx] = tower[idx];
		// idx 왼쪽
		for(int i = idx-1; i>=0; i--) {
			arr[i] = arr[i+1] - k;
			if(arr[i] <= 0)
				return false;
		}
		for(int i = idx+1; i<n; i++) {
			arr[i] = arr[i-1] + k;
		}
		
		return true;
	}
	public static int checkDiff() {
		int count = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i] != tower[i])
				count++;
		}
		return count;
	}
}