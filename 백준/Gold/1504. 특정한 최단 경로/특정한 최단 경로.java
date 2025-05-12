import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int next;
		int cost;
		Node(int next, int cost){
			this.next = next;
			this. cost = cost;
		}
	}
	static List<ArrayList<Node>> map;
	static boolean[] visit;
	static int[] dist;
	static int N, E;
	static final int INF = 200000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		visit = new boolean[N+1];
		dist = new int[N+1];

		Arrays.fill(dist, INF);

		for(int i = 0; i<=N; i++)
			map.add(new ArrayList<>());

		for(int i = 0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map.get(a).add(new Node(b, c));
			map.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);

		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		int answer = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.println(answer);
	}
	public static int dijkstra(int start, int end){
		Arrays.fill(dist, INF);
		Arrays.fill(visit, false);

		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()){
			Node curNode = pq.poll();
			int cur = curNode.next;
			if(!visit[cur]){
				visit[cur] = true;

				for(Node node : map.get(cur)){
					if(!visit[node.next] && dist[node.next] > dist[cur] + node.cost){
						dist[node.next] = dist[cur] + node.cost;
						pq.add(new Node(node.next, dist[node.next]));
					}
				}
			}
		}

		return dist[end];
	}
}
