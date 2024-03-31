
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 1~n까지 자연수
		m = Integer.parseInt(st.nextToken()); // m자리
		visit = new boolean[n+1];
		
		solve("", 0, 1);
		System.out.println(sb);
	}
	public static void solve(String str, int depth, int idx) {
		if(depth == m) {
			sb.append(str).append("\n");
			return;
		}
		
		for(int i = idx; i<=n; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			solve(str.concat(i + " "), depth+1, i);
			visit[i] = false;
		}
		
	}
}