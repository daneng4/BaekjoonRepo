import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if(n == 1) {
			System.out.println("4");
			return;
		}

		long[] arr = new long[n+1];
		arr[1] = 1; arr[2] = 1;
		
		for(int i = 3; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		long answer = (arr[n] + arr[n] + arr[n-1]) * 2;
		System.out.println(answer);
	}
}