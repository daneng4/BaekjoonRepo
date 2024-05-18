
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		solve(0,0);
		list.sort(null);
		
		try {
			System.out.println(list.get(N - 1));
		} catch (Exception e) {
			System.out.println(-1);
		}
	}
	public static void solve(long num, int inx) {
		if (!list.contains(num)) {
			list.add(num);
		}

		if (inx >= 10) {
			return;
		}

		solve((num * 10 + arr[inx]), inx + 1);
		solve(num, inx + 1);
	}
}