
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int n;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i = 1; i<=n; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		
		dfs(1, 0, visit);
		if(answer % 2 == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	public static void dfs(int node, int count, boolean[] visit) {	
		visit[node] = true;
		
		for(int next : map[node]) {
			if(!visit[next])
				dfs(next, count+1, visit);
		}
		
		if(node != 1 && map[node].size() == 1)
			answer += count;
		
	}
}