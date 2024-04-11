
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=testCase; tc++) {
			int testCaseNumber = Integer.parseInt(br.readLine());
			int[] nums = new int[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<1000; i++) {
				int num = Integer.parseInt(st.nextToken());
				nums[num]++;
			}
			int max = 0;
			int maxIdx = 0;
			for(int i = 100; i>=0; i--) {
				if(nums[i] > max) {
					max = nums[i];
					maxIdx = i;
				}
			}
			
			bw.write(String.format("#%d %d\n", testCaseNumber, maxIdx));
		}// end tc
		
		bw.flush();
	}
}
