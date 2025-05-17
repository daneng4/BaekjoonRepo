import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visit;
    static ArrayList<Integer>[] map;
    static int[] dist;
    static class Node{
        int node;
        int dist;
        Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new boolean[n+1];
        map = new ArrayList[n+1];
        dist = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            int a = edge[i][0]; 
            int b = edge[i][1];
            map[a].add(b);
            map[b].add(a);
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs();
        
        int max = 0;
        for(int i = 1; i<dist.length; i++){
            max = Math.max(max, dist[i]);
        }
        for(int i = 1; i<dist.length; i++){
            if(max == dist[i]) answer+=1;
        }
        
        return answer;
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visit[1] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            dist[cur.node] = Math.min(dist[cur.node], cur.dist);
            
            for(int next : map[cur.node]){
                if(visit[next]) continue;
                
                q.add(new Node(next, cur.dist + 1));
                visit[next] = true;
            }
        }
        
        
    }
}