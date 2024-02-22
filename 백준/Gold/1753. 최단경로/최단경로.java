
import java.util.*;
import java.io.*;

/*
 * 다익스트라
 * 방문하지 않은 노드 중 가장 비용이 적은 노드를 선택
 * 해당 노드로부터 갈 수 있는 노드들의 비용을 갱신
*/
public class Main {
	public static int [] ans;
    public static boolean [] visit;
    public static ArrayList<Node>[] nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		int K = Integer.parseInt(br.readLine()); // 시작 정점 K
		ans = new int[V+1];
		visit = new boolean[V+1];
		nodes = new ArrayList[V+1];
		
		for(int i = 1; i<=V; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i = 1; i<=V; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		
		// u,v,w -> u에서 v로 가는 가중치가 w인 간선 정보
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[u].add(new Node(v, w)); // u라는 노드에서 v노드까지의 가중치 정보 저장
		}
		
		ans[K] = 0; // 시작노드 0 초기화
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; i++) {
			if(i == K)
				sb.append(0 + "\n");
			else if(ans[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		// 가중치가 작은 순서로 뽑기 위해 우선순위 큐 사용
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			// 방문하지 않은 노드 중 가장 작은 노드 선택
			Node curNode = pq.poll();
			// 방문했다면 continue
			if(visit[curNode.value])
				continue;
			
			visit[curNode.value] = true;
			
			// 해당 노드로부터 갈 수 있는 다른 노드들의 가중치 최소 비용을 갱신한다.
			for(Node node : nodes[curNode.value]) {
				if(ans[node.value] > ans[curNode.value] + node.weight) {
					ans[node.value] = ans[curNode.value] + node.weight; 
					pq.add(new Node(node.value, ans[node.value]));
				}
			}
		}
	}
	
}

class Node implements Comparable<Node>{
	int value;
	int weight; 
	
	Node(int value, int weight){
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
	
}

