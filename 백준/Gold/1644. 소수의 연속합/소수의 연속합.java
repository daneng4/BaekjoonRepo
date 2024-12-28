
import java.util.*;
import java.io.*;

public class Main {
	static boolean[] isPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		isPrime = new boolean[N+1];
		
		getPrime(N);
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		for(int i = 2; i<=N; i++) {
			if(isPrime[i]) {
				primes.add(i);
			}
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		while(true) {
			if(sum >= N ) sum -= primes.get(start++);
        	else if(end == primes.size()) break;
        	else sum += primes.get(end++);       	
        	if(N==sum) answer++;
		}
		
		System.out.println(answer);
	}
	public static void getPrime(int N) {
		for(int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i<=Math.sqrt(N); i++) {
			if(isPrime[i]) {
				for(int j = i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
	}
}