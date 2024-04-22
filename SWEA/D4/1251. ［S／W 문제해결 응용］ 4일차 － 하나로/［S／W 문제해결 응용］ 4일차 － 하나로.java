
import java.awt.Point;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			long[] x = new long[n];
			long[] y = new long[n];
			boolean[] visit = new boolean[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());
			ArrayList<Node>[] list = new ArrayList[n];
			
			for(int i = 0; i<n; i++) {
				list[i] = new ArrayList<>();
				for(int j = 0; j<n; j++) {
					if(i==j) continue;
					long dis = (x[i]-x[j]) * (x[i]-x[j]) + (y[i]-y[j]) * (y[i]-y[j]);
					list[i].add(new Node(j, dis));
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0));
			long answer = 0;
			int count = 0;
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(visit[node.to]) continue;
				visit[node.to] = true;
				answer += node.cost;
				if(count == n)
					break;
				
				for(Node next : list[node.to]) {
					if(!visit[next.to])
						pq.add(next);
				}
			}
			bw.write(String.format("#%d %d\n", test_case, Math.round(answer*e)));
		} // end of testcase
		bw.flush();
	}
}
class Node implements Comparable<Node>{
	int to;
	long cost;
	Node(int to, long cost){
		this.to = to;
		this.cost = cost;
	}
	public int compareTo(Node n) {
		return Long.compare(this.cost, n.cost);
	}
}