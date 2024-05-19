import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Node> list;
	static int[] parent;
	static int v,e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			parent = new int[v+1];
			init();
			
			for(int i = 0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.add(new Node(a,b,c));
			}
			
			long answer = 0;
			int count = 0;
			Collections.sort(list);
            
			for(Node next : list) {
				if(!union(next.x, next.y)) {
					answer += next.cost;
				}
				
				if(count + 1 == v-1)
					break;
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
	public static void init() {
		for(int i = 1; i<=v; i++) {
			parent[i] = i;
		}
	}
	public static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if(aroot == broot)
			return true;
		
		parent[broot] = aroot;
		return false;
	}
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = find(parent[x]);
	}
}
class Node implements Comparable<Node>{
	int x;
	int y;
	int cost;
	Node(int x, int y, int cost){
		this.x = x; this.y = y; this.cost = cost;
	}
	public int compareTo(Node n) {
		return this.cost - n.cost;
	}
}