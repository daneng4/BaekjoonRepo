import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int size = 1000000;
		long[] arr = new long[size+1];
		arr[1] = 1; arr[2] = 2; arr[3] = 4;
		for(int i = 4; i<=size; i++) {
			arr[i] = (arr[i-1]+arr[i-2]+arr[i-3]) % 1000000009;
		}
		
		for(int i = 0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			System.out.println(arr[m]);
		}
	}
}