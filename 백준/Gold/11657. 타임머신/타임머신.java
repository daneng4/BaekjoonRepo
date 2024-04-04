
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<edge> list = new ArrayList<>();

		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new edge(start, end, cost));
		}
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(edge e : list) {
				if(dist[e.start] == Long.MAX_VALUE)
					continue;
				
				if(dist[e.end] > dist[e.start] + e.cost) {
					dist[e.end] = dist[e.start] + e.cost; 
					
					if(i == n) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		for(int i = 2; i<=n; i++) {
			if(dist[i] == Long.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(dist[i]);
		}
	}
}
class edge{
	int start;
	int end;
	int cost;
	
	public edge(int start, int end, int cost) {
		this.start = start; this.end = end; this.cost = cost;
	}
}