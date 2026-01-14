import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Integer>[] map;
	static int[] visit;
	static boolean isCycle;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int K = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	while(K-->0) {
    		st = new StringTokenizer(br.readLine());
    		
    		int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	map = new ArrayList[V+1];
        	visit = new int[V+1];
        	isCycle = false;
        	
        	for(int i = 1; i<=V; i++)
        		map[i] = new ArrayList<>();
        	
        	for(int i = 0; i<E; i++) {
        		st = new StringTokenizer(br.readLine());
        		int u = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		
        		map[u].add(v);
        		map[v].add(u);
        	}
        	
        	for(int i = 1; i<=V; i++) {
        		if(visit[i] != 0)
        			continue;
        		dfs(i, 1);        		
        	}
        	
        	if(isCycle)
        		sb.append("NO\n");
        	else
        		sb.append("YES\n");
    	}
    	
    	System.out.println(sb);
    }
    public static void dfs(int node, int number) {
    	if(visit[node] != 0) {
    		// 내 다음이 나와 같은 숫자를 가지고 있다면 홀수사이클
    		if(visit[node] == -number) {
    			isCycle = true;    			
    		}
    		
    		return;
    	}
    	
    	visit[node] = number;
    	for(int next : map[node]) {
    		dfs(next, -number);
    	}
    }
}