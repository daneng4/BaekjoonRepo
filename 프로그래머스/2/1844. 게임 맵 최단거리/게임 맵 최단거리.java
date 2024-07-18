import java.util.*;
class Solution {
    static int[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        visit = new int[maps.length][maps[0].length];

        int startx = 0; int starty = 0;
        visit[startx][starty] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startx, starty});
    
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for(int i = 0; i<4; i++){
                int nextx = x+dx[i];
                int nexty = y+dy[i];
                
                if(nextx < 0 || nexty < 0 || nextx > maps.length-1 || nexty > maps[0].length-1)
                    continue;
                
                if(visit[nextx][nexty] == 0 && maps[nextx][nexty] == 1){
                    visit[nextx][nexty] = visit[x][y]+1;
                    q.add(new int[] {nextx, nexty});
                }
                
                
                
            }
        }
        
        answer = visit[maps.length-1][maps[0].length-1];
        if(answer == 0)
            return -1;
    
        return answer;
    }
}