import java.util.*;
import java.io.*;

public class Main {
	static boolean[] isPrime;
	static int max = 10000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 최대 값 까지의 소수를 구한다.
		isPrime = new boolean[max];
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1)
			return;
		
		Arrays.fill(isPrime, true);
		prime();
		
		StringBuilder sb = new StringBuilder();
		// n이 소수일 때까지 소수들로 나눈다.
		while(!isPrime[n]) {
			for(int i = 2; i<=isPrime.length; i++) {
				if(n % i == 0 && isPrime[i]) {
					n = n / i;
					sb.append(i + "\n");
					break;
				}
			}
		}
		sb.append(n);
		
		System.out.println(sb.toString());
	}
	public static void prime() {
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i<=Math.sqrt(max); i++) {
			if(!isPrime[i])
				continue;
			for(int j = i*i; j<max; j+=i) {
				isPrime[j] = false;
			}
		}
	}
}