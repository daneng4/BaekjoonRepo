
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int n,m;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Node n) {
			return weight - n.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		long total = 0;
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
			total += c;
		}
		
		long cost = solve();
		System.out.println(cost == -1? -1 : total-cost);
	}
	public static long solve() {
		long sum = 0;
		int cnt = 0;
		boolean[] visit = new boolean[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			if(cnt == n)
				break;
			Node now = pq.poll();
			
			if(visit[now.to])
				continue;
			visit[now.to] = true;
			sum+=now.weight;
			cnt++;
			
			for(Node next : list[now.to]) {
				if(visit[next.to])
					continue;
				pq.offer(next);
			}
		}

		return cnt == n ? sum : -1;
	}
}