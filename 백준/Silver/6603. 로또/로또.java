
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb = new StringBuilder();
	static int k;
	static String[] nums;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0)
				break;
			
			nums = new String[k];
			
			for(int i = 0; i<k; i++) {
				nums[i] = st.nextToken();
			}
			
			for(int i = 0; i<nums.length-6; i++) {
				dfs(nums[i], 0, i);
			}
			for(int i = nums.length-6; i<nums.length; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(String str, int depth, int idx) {
		if(depth == 5) {
			sb.append(str).append("\n");
			return;
		}
		
		for(int i = idx+1; i<nums.length; i++) {
			dfs(str.concat(" ").concat(nums[i]), depth+1, i);
			
		}
		
	}
}

