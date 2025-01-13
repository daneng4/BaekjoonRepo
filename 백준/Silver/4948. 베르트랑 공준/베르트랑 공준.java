
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = 123456;
    	isPrime = new boolean[2 * n + 1];
    	Arrays.fill(isPrime, true);
    	setPrime(2 * n);
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		int input = Integer.parseInt(br.readLine());
    		if(input == 0)
    			break;
    		
    		int count = 0;
    		for(int i = input+1; i<=2 * input; i++) {
    			if(isPrime[i])
    				count+=1;
    		}
    		sb.append(count + "\n");
    	}
    	System.out.println(sb.toString());
    }
	public static void setPrime(int n) {
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(!isPrime[i])
				continue;
			for(int j = i*i; j<=n; j+=i) {
				isPrime[j] = false;
			}
		}
	}
}