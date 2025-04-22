import java.io.*;
import java.util.*;

public class Main {
    static int n;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);

	}
	static void dfs(int num, int count){
		if(count == n){
			if(isPrime(num)){
				System.out.println(num);
			}
			return;
		}

		for(int i = 1; i<=9; i++){
			if(isPrime(num * 10 + i)){
				dfs(num * 10 + i, count + 1);
			}
		}

	}
	static boolean isPrime(int num){
		for(int i = 2; i<=Math.sqrt(num); i++){
			if(num % i == 0)
				return false;
		}

		return true;
	}
}
