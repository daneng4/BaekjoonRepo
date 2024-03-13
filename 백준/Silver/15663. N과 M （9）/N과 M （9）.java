
import java.util.*;
import java.io.*;

public class Main {
	static int[] num, perm;
	static int n,m;
	static boolean[] visit;
	static LinkedHashSet<String> ans; // 입력된 순으로 정렬, 중복 제거
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		perm = new int[m];
		visit = new boolean[n];
		ans = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		dfs(0);
		
		for(String s : ans) {
			System.out.println(s);
		}
	}	
	
	public static void dfs(int depth) {
		if(depth == m) {
			StringBuilder sb = new StringBuilder();
			for(int p : perm) {
				sb.append(p).append(" ");
			}
			ans.add(sb.toString());
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			perm[depth] = num[i];
			dfs(depth+1);
			visit[i] = false;
		}
		
	}
}

