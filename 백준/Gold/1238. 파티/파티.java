
import java.io.*;
import java.util.*;


public class Main {
	static ArrayList<Node>[] road;
	static ArrayList<Node>[] reverse;
	static int[] dist;
	static int flag = 0;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 학생수
		int m = Integer.parseInt(st.nextToken()); // 단방향 도로 수
		int x = Integer.parseInt(st.nextToken()); // 파티하는 마을
		
		road = new ArrayList[n+1];
		reverse = new ArrayList[n+1];
		int[] result = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			road[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			road[a].add(new Node(b,v)); 
			reverse[b].add(new Node(a,v));
		}
		
		boolean[] visit = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[x] = 0;
		check(x, visit);
		flag += 1;
		for(int i = 1; i<=n; i++) {
			result[i] = dist[i];
		}
		for(int i = 1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[x] = 0;
		Arrays.fill(visit, false);
		check(x, visit);
		for(int i = 1; i<=n; i++) {
			result[i] += dist[i];
		}
		
		int answer = 0;
		for(int i = 1; i<=n; i++) {
			answer = Math.max(result[i], answer);
		}
		System.out.println(answer);
		
	}
	public static void check(int start, boolean[] visit) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		if(flag == 0) {
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				if(visit[curNode.end])
					continue;
				
				visit[curNode.end] = true;
				
				for(Node node : reverse[curNode.end]) {
					if(dist[node.end] > dist[curNode.end] + node.value) {
						dist[node.end] = dist[curNode.end] + node.value;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		else {
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				if(visit[curNode.end])
					continue;
				
				visit[curNode.end] = true;
				
				for(Node node : road[curNode.end]) {
					if(dist[node.end] > dist[curNode.end] + node.value) {
						dist[node.end] = dist[curNode.end] + node.value;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		
		
	}
}

class Node implements Comparable<Node>{
	int end;
	int value;
	
	Node(int end, int value) {
		this.end = end;
		this.value = value;
	}
	
	public int compareTo(Node n) {
		return value - n.value;
	}
}
