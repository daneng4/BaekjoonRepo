
import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int result = 0;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		solve(0);
		System.out.println(result);
	}	
	static void solve(int depth) {
		
		if(depth == n) {
			result++;
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[depth] = i;
			if(check(depth)) {
				solve(depth+1);
			}
		}
		
	}
	static boolean check(int depth) {
		
		for(int i = 0; i<depth; i++) {
			if(arr[depth] == arr[i])
				return false;
			else if (Math.abs(depth-i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
}

