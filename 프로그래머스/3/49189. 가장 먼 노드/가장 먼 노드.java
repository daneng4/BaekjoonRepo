import java.util.*;
class Solution {
    static boolean [] visit;
    static ArrayList<Integer>[] list;
    static int[] far;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        far = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        solve(1);
        int max = 0;
        for(int i = 1; i<=n; i++){
            max = Math.max(max, far[i]);
        }
        for(int i = 1; i<=n; i++){
            if(far[i] == max)
                answer++;
        }
        
        return answer;
    }
    public static void solve(int start){
        Queue<int[]> q = new LinkedList<>();
        visit[start] = true;
        q.add(new int[] {start, 0});
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int now = poll[0];
            int count = poll[1];
            far[now] = count;
            
            for(int next : list[now]){
                if(visit[next]) continue;
                q.add(new int[] {next, count + 1});
                visit[next] = true;
            }
        }
        
    }
}