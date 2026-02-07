import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        int[] ch = new int[n+1];
        for(int i = 0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int ev = tmp.vertex;
            
			if(ch[ev]==0){
				ch[ev]=1;
				answer+=tmp.cost;
				for(Edge ob : graph.get(ev)){
					if(ch[ob.vertex]==0) pq.offer(new Edge(ob.vertex, ob.cost));
				}
			}
            
        }
        
        return answer;
    }
}

// cost 기준 오름차순 정렬하는 클래스
class Edge implements Comparable<Edge> {
    int vertex;
    int cost;
    
    public Edge(int vertex, int cost){
        this.vertex = vertex; this.cost = cost;
    }
    
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}