
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int n,m;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Node n) {
			return this.weight - n.weight;
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
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, cost));
			list[end].add(new Node(start, cost));
		}
		
		int MSTweight = solve();
		System.out.println(MSTweight);
	}
	public static int solve() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[n+1];
		
		pq.add(new Node(1,0));
		int sum = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			if(count == n)
				break;
			Node now = pq.poll();
			if(visit[now.end])
				continue;
			visit[now.end] = true;
			count++;
			sum += now.weight;
			
			for(Node next : list[now.end]) {
				if(visit[next.end])
					continue;
				pq.offer(next);
			}
		}
		
		return sum;
	}
}