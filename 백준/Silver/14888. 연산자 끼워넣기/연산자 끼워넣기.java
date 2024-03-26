import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int[] num;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(op, num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int[] op, int sum, int depth) {
		if(depth == n) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(op[i] == 0)
				continue;
			
			op[i]--;
			// 덧셈이라면
			if(i == 0)
				dfs(op, sum + num[depth], depth+1);
			// 뺄셈이라면
			else if(i == 1)
				dfs(op, sum - num[depth], depth+1);
			// 곱셈이라면
			else if(i == 2)
				dfs(op, sum * num[depth], depth+1);
			// 나눗셈이라면
			else {
				// 음수의 나눗셈이라면
				if(sum < 0) {
					dfs(op, -(Math.abs(sum) / num[depth]), depth+1);
				}else {
					dfs(op, sum / num[depth], depth+1);
				}
			}
			op[i]++;
		}
		
		
	}
}