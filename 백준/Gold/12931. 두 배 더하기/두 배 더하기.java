
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		while(true) {
			for(int i = 0; i<a.length; i++) { // 배열 내 요소를 전부 짝수로
				int num = a[i];
				if(num % 2 == 1) {
					a[i] = a[i] - 1;
					result++;
				}				
			}
			int[] b = a.clone();
			Arrays.sort(b);
			if(b[b.length-1] == 0) 
				break;
			
			for(int i = 0; i<a.length; i++) { // 배열 내 요소들 전부 2로 나눔
				a[i] = a[i] / 2;
			}
			result++;
		}
		
		System.out.println(result);
		
	}
}
