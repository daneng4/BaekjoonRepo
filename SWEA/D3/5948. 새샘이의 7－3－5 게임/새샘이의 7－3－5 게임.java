import java.util.*;
import java.io.*;

public class Solution {
	static int[] nums;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			nums = new int[7];
			list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<7; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,0,0);
			Collections.sort(list, Collections.reverseOrder());
			
			bw.write(String.format("#%d %d\n", t, list.get(4)));
		} // testcase
		bw.flush();
	}
	public static void solve(int sum, int depth, int count) {
		// 숫자 3개를 골랐다면
		if(count == 3) {
			if(!list.contains(sum))
				list.add(sum);
			return;
		}
		
		if(depth == nums.length) {
			if(count == 3) {
				if(!list.contains(sum))
					list.add(sum);
			}
			return;
		}
		
		solve(sum , depth+1, count);
		solve(sum + nums[depth], depth+1, count+1);
		
	}
}