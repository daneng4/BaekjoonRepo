
import java.util.*;
import java.io.*;

class Node {
	int start;
	int end;
	int cost;

	Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long max = Long.MAX_VALUE;

		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(start, end, cost));
		}

		long[] dist = new long[n + 1];
		Arrays.fill(dist, max);
		dist[1] = 0;

		for (int i = 1; i <= n; i++) {
			for (Node node : list) {
				if (dist[node.start] == max) 
					continue;
				
				if(dist[node.end] > dist[node.start] + node.cost) {
					dist[node.end] = dist[node.start] + node.cost;
					
					if(i == n) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		for(int i = 2; i<=n; i++) {
			if(dist[i] == max)
				System.out.println(-1);
			else
				System.out.println(dist[i]);
		}

	}
}
