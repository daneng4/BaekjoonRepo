
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 나무 수
		int m = Integer.parseInt(st.nextToken()); // 가져갈 길이
		int[] arr = new int[n];
		
		int max = 0;
		int min = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			int wood = Integer.parseInt(st.nextToken());
			arr[i] = wood;
			if(wood > max)
				max = wood;
		}
		
		
		while(min < max){
			int mid = (min + max) / 2;
			long sum = 0;
			
			for(int height : arr) {
				if(height - mid > 0) { // 자른게 0보다 크면 sum에 더함
					sum += (height - mid);
				}	
			}
			
			if(sum < m) {
				max = mid;
			}else {
				min = mid + 1;
			}
			
		} // end of while
	
		System.out.println(min-1);
	}
}
