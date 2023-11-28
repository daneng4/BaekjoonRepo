
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr1 = new Integer[n];
		Integer[] arr2 = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		int sum = 0;
		for(int i = 0; i<n; i++) {
			sum+= arr1[i] * arr2[i];
		}
		System.out.println(sum);
	}
}
