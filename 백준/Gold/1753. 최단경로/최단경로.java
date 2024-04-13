
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		visit = new boolean[v+1];
		list = new ArrayList[v+1];
		ans = new int[v+1];
		for(int i = 1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i<=v; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
		}
		ans[start] = 0;
		algo(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=v; i++) {
			if(i == start)
				sb.append("0\n");
			else if(ans[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}
	public static void algo(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visit[cur.end])
				continue;
			visit[cur.end] = true; 
			
			for(Node n : list[cur.end]) {
				if(ans[n.end] > ans[cur.end] + n.weight) {
					ans[n.end] = ans[cur.end] + n.weight;  
					pq.add(new Node(n.end, ans[n.end]));
				}
			}
			
		}
		
	}
}
class Node implements Comparable<Node>{
	int end;
	int weight;
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}
