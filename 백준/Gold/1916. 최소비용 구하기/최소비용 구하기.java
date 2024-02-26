import java.util.*;
import java.io.*;

/*
 * 다익스트라
 * 방문하지 않은 노드 중 가장 비용이 적은 노드를 선택
 * 해당 노드로부터 갈 수 있는 노드들의 비용을 갱신
*/
public class Main {
	static ArrayList<Station>[] stat;
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		stat = new ArrayList[n+1];
		visit = new boolean[n+1];
		ans = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			stat[i] = new ArrayList<>();
			ans[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			stat[start].add(new Station(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		ans[s] = 0;
		algo(s);
		System.out.println(ans[e]);
		
	}
	public static void algo(int s) {
		PriorityQueue<Station> pq = new PriorityQueue<>();
		pq.add(new Station(s, 0));
		
		while(!pq.isEmpty()) {
			Station cur = pq.poll();
			if(visit[cur.node])
				continue;
			
			visit[cur.node] = true;
			
			for(Station next : stat[cur.node]) {
				if(ans[next.node] > ans[cur.node] + next.cost) {
					ans[next.node] = ans[cur.node] + next.cost; 
					pq.add(new Station(next.node, ans[next.node]));
				}
			}
			
		}
		
		
	}
}

class Station implements Comparable<Station>{
	int node;
	int cost;
	
	Station(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	
	public int compareTo(Station s) {
		return cost - s.cost;
	}
}

