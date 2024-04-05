

import java.util.*;
import java.io.*;

class node implements Comparable<node>{
	int start;
	int end;
	int cost;
	public node(int start, int end, int cost) {
		this.start = start; 
		this.end = end;
		this.cost = cost;
	}
	
	public int compareTo(node n) {
		return this.cost - n.cost;
	}
}
public class Main {
	static int n,m;
	static int[] parent;
	static long result;
	static int max;
	static PriorityQueue<node> q = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			q.add(new node(a, b, c));
		}

		while(!q.isEmpty()) {
			node poll = q.poll();
			if(!isParent(poll.start, poll.end)) {
				union(poll.start, poll.end);
				result += poll.cost;
				max = poll.cost;
			}
		}
		System.out.println(result - max);
	}
	public static int find(int x) {
		if(x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	public static boolean isParent(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		if(xp != yp)
			return false;
		else
			return true;
	}
	public static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		parent[yp] = xp;
	}
}
