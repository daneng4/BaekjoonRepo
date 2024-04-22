
import java.awt.Point;
import java.io.*;
import java.util.*;

// MST - Kruskal 알고리즘 (간선)
class Edge implements Comparable<Edge>{
	int from;
	int to;
	long cost;
	public Edge(int from, int to, long cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	public int compareTo(Edge e) {
		return Long.compare(this.cost, e.cost);
	}
}
class Solution {
	static int[] parents;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			long[] x = new long[n];
			long[] y = new long[n];
			
			// 정점 간선 연결 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			// 부모 노드 초기화
			parents = new int[n+1];
			for(int i = 0; i<n; i++) {
				parents[i] = i;
			}
			
			// 연결 정보 + 가중치 정보 입력
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i = 0; i<n; i++) {
				for(int j = i+1; j<n; j++) {
					long dis = (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]);
					pq.add(new Edge(i,j,dis));
				}
			}
			
			long answer = 0;
			int count = 0;
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				// 시작 정점, 끝 정점이 이미 union되어있다면 통과
				if(union(e.to, e.from))
					continue;
				answer += e.cost;
				count++;
				// 크루스칼은 n-1에서 종료한다. 간선이기 때문에, 프림은 n
				if(count == n-1)
					break;
			}
			bw.write(String.format("#%d %d\n", test_case, Math.round(answer*E)));
		} // end of testcase
		bw.flush();
	}
	public static boolean union(int a, int b) {
		// a와 b의 부모 정보를 확인
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parents[pb] = pa;
			return false;
		}
		return true;
	}
	public static int find(int num) {
		// 부모 노드를 찾았다면 리턴
		if(parents[num] == num)
			return num;
		// 못찾았다면 상위 노드를 찾아 재귀
		return parents[num] = find(parents[num]);
	}
}
