
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		
		for(int i = 0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int answer = 0; // 합
		int diff = Integer.MAX_VALUE; // 차
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i == j) continue;
				for(int k = 0; k<n; k++) {
					if(j == k || i == k) continue;
					
					int sum = nums[i] + nums[j] + nums[k];
					
					if(target - sum < 0)
						continue;
			
					if(diff > target - sum) {
						diff = target - sum;
						answer = sum;
					}
					
				}
			}
		}
		
		System.out.println(answer);
		
	}
}