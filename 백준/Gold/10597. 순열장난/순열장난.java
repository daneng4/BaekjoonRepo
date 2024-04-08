
import java.io.*;
import java.util.*;

public class Main {
	static String s;
	static boolean[] visit;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		len = s.length();
		visit = new boolean[51];
		dfs(0, 0, "");
		
	}
	public static void dfs(int idx, int n, String str) {
		if(idx == len) {
			for(int i = 1; i<=n; i++) {
				if(!visit[i])
					return;
			}
			System.out.println(str.trim());
			System.exit(0);
			return;
		}
		
		String temp = s.substring(idx, idx+1);
		int num = Integer.parseInt(temp);
		if(!visit[num]) {
			visit[num] = true;
			dfs(idx+1, (num > n)? num : n, str + " " + temp);
			visit[num] = false;
		}
		if(idx < len - 1) {
			temp = s.substring(idx, idx+2);
			num = Integer.parseInt(temp);
			if(num < 51 && !visit[num]) {
				visit[num] = true;
				dfs(idx+2, (num > n)? num : n, str + " " + temp);
				visit[num] = false;
			}
		}
		
	}
}