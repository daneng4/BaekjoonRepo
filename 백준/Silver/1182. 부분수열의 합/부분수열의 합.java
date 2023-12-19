
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static int n, s;
	static int result = 0;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i  = 0; i<n; i++) {
			dfs(i, 0);
		}
		
		System.out.println(result);
	}
	public static void dfs(int nowIndex, int sum) {
		if(nowIndex == n) {
			return;
		}
		
		// sum에 현재 인덱스의 수를 더함
		sum += arr[nowIndex];

		// sum이 s와 같으면 result++
		if(sum == s) {
			result++;
		}
		
		// 현재 인덱스 보다 오른쪽 배열 중 방문 안한 값들을 탐색 
		for(int i = nowIndex; i<n; i++) {
			dfs(i+1, sum);
			
		}
	}
}
