import java.io.*;
import java.util.*;

public class Main {
	static String[] prime = {"2","3","5","7"};
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<prime.length; i++) {
			dfs(prime[i], 1);
		}
		
		System.out.println(sb);
	}
	public static void dfs(String num, int len) {
		if(len == n) {
			if(isPrime(num))
				sb.append(num).append("\n");
			return;
		}
		
		for(int i = 0; i<=9; i++) {
			if(!isPrime(num+i))
				continue;
			dfs(num+i, len+1);
			
		}
		
	}
	public static boolean isPrime(String str) {
		int primeNum = Integer.parseInt(str);
		for(int i = 2; i <= primeNum/2; i++) {
			if(primeNum % i == 0)
				return false;
		}
		return true;
	}
}




