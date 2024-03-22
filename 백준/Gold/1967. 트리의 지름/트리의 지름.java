
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visit;
	static int[] maxLen;
	static ArrayList<Node>[] graph;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		maxLen = new int[n+1];
		visit = new boolean[n+1];
		
		for(int i = 1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, weight));
			graph[b].add(new Node(a, weight));
		}
		
		for(int i = 1; i<=n; i++) {
			dfs(i, i, 0);
			Arrays.fill(visit, false);
		}
		
		int result = 0;
		for(int diameter : maxLen) {
			result = Math.max(diameter, result);
		}
		
		System.out.println(result);
	}
	public static void dfs(int startNode, int curNode, int len) {
		visit[curNode] = true;
		maxLen[startNode] = Math.max(maxLen[startNode], len);
		
		for(Node n : graph[curNode]) {
			if(visit[n.value])
				continue;
			
			dfs(startNode, n.value, len+n.weight);
		}
	}

}
class Node{
	int value;
	int weight;
	
	Node(int value, int weight){
		this.value = value;
		this.weight = weight;
	}
	
}




