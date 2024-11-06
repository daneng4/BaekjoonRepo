
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		double sum = 0;
		
		for(int i = 0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		
		Arrays.sort(nums);
		
		// 산술평균, 첫째자리 반올림
		System.out.println(avg(sum, n));
		// 중앙값 
		System.out.println(nums[n/2]);
		// 최빈값
		System.out.println(getMaxAppear(nums));
		// 범위
		System.out.println(nums[nums.length-1] - nums[0]);
		
    }
	static long avg(double sum, int n) {
		if(sum / n >= 0) {
			return Math.round(sum / n);
		}else {
			double avg = sum / n;
			return Math.round(avg);
		}
	}
	static int getMaxAppear(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		int max = 0;
		
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for(int key : map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int key : map.keySet()) {
			if(map.get(key) == max)
				q.add(key);
		}
		if(q.size() > 1) {
			q.poll();
			return q.poll();
		}else
			return q.poll();
	}
}