import java.util.*;
import java.io.*;

public class Solution {
	static int[] parents;
	static int v,e;
	static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
        	v = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	parents = new int[v+1];
        	list = new ArrayList<>();
        	init();
        	
        	for(int i = 0; i<e; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		
        		list.add(new Node(a,b,c));
        	}
        	
        	Collections.sort(list);
        	int count = 0;
        	long result = 0;
        	
        	for(Node next : list) {
        		if(!union(next.x, next.y)) {
        			// 부모가 다르면
        			result += next.cost;
        			if(count + 1 == v-1)
        				break;
        		}
        	}
        	
        	bw.write(String.format("#%d %d\n", tc, result));
        }// tc
        bw.flush();
    }
    public static void init() {
    	for(int i = 1; i<=v; i++) {
    		parents[i] = i;
    	}
    }
    public static boolean union(int a, int b) {
    	int aparent = find(a);
    	int bparent = find(b);
    	if(aparent == bparent)
    		return true;
    	parents[bparent] = aparent;
    	return false;
    }
    public static int find(int x) {
    	if(parents[x] == x)
    		return x;
    	return parents[x] = find(parents[x]);
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
		return cost - n.cost;
	}
}