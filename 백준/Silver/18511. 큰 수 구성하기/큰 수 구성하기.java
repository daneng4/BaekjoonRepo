
import java.io.*;
import java.util.*;

public class Main {
	
	public static int n;
	public static int m;
	public static Integer[] k;
	public static int ans;
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = new Integer[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			k[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(k);
		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int now) {
		if(now > n)
			return;
		if(ans < now)
			ans = now;
		for(int i = m-1; i > -1; i--) {
			dfs(now*10+k[i]);
		}
	}
}
