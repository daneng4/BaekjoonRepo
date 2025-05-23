import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> list;
	static int[] nums;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		nums = new int[n+1];
		visit = new boolean[n+1];

		for(int i = 1; i<=n; i++){
			nums[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 1; i<=n; i++){
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}

		System.out.println(list.size());
		Collections.sort(list);
		for(int e : list){
			System.out.println(e);
		}
	}
	public static void dfs(int start, int target){
		if(!visit[nums[start]]){
			visit[nums[start]] = true;
			dfs(nums[start], target);
			visit[nums[start]] = false;
		}
		if(nums[start] == target){
			list.add(target);
		}
	}
}
