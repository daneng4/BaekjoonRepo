
import java.util.*;
import java.io.*;

public class Main {
	static int[] num = {9,8,7,6,5,4,3,2,1,0};
	static List<Long> list;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		dfs(0,0);
		Collections.sort(list);
		if(list.size() < n)
			System.out.println(-1);
		else
			System.out.println(list.get(n-1));
	}
	public static void dfs(long n, int idx) {
		if(!list.contains(n))
			list.add(n);
		// 자릿수가 10이상이면 return
		if(idx >= 10)
			return;
		
		dfs(n * 10 + num[idx], idx+1);
		dfs(n, idx+1);
	}
}