
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int[] cost;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		cost = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<=n; i++) {
			map[i] = new ArrayList<>();
		}
		
		// 양방향 건물 도로 정보 저장
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		int c1, c2;
		PriorityQueue<info> pq = new PriorityQueue<>();
		// 임의의 두 건물을 치킨집으로 지정
		for(int i = 1; i<n; i++) {
			for(int j = i+1; j<=n; j++) {
				c1 = i; c2 = j;
				int sum = 0;
				for(int k = 1; k<=n; k++) {
					if(k == c1 || k == c2)
						continue;
					solve(c1, c2, k, k, 0);
					sum += cost[k];
				}
				pq.offer(new info(c1, c2, sum * 2));
			}
		}
		StringBuilder sb = new StringBuilder();
		info answer = pq.poll();
		sb.append(answer.c1).append(" ").append(answer.c2).append(" ").append(answer.w);
		System.out.println(sb);
	}
	public static void solve(int c1, int c2, int start, int cur, int c) {
		// 치킨집 둘중 하나에 도착했을 때
		if(cur == c1 || cur == c2) {
			// 지금까지 걸린 비용을 갱신
			cost[start] = Math.min(cost[start], c);
			return;
		}
		
		visit[cur] = true;
		for(int i = 1; i<=n; i++) {
			if(!visit[i])
				solve(c1, c2, start, i, c+1);
		}

	}
}
class info implements Comparable<info>{
	int c1;
	int c2;
	int w;
	info(int c1, int c2, int w){
		this.c1 = c1;
		this.c2 = c2;
		this.w = w;
	}
	public int compareTo(info i) {
		return this.c2 - i.c2;
	}
}