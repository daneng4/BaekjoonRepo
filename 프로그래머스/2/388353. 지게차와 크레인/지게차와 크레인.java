import java.io.*;
import java.util.*;

class Solution {
    static boolean[][] taked;
    static char[][] map;
    static int size;
    static int x;
    static int y;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(String[] storage, String[] requests) {     
        x = storage.length;
        y = storage[0].length();
        size = x*y;
        
        taked = new boolean[x+2][y+2];
        map = new char[x+2][y+2];
        
        for(int i = 1; i<=storage.length; i++){
            for(int j = 1; j<=storage[i-1].length(); j++){
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }

        for(int i = 0; i<requests.length; i++){
            String request = requests[i];
            
            if(request.length() == 1){
                lift(request.charAt(0));
            }else{
                crane(request.charAt(0));
            }
        }
        
        return size;
    }
    public static void lift(char request){
        // 꺼내 질 컨테이너 파악을 위한 2차원 배열
        boolean[][] check = new boolean[x+2][y+2];
        boolean[][] visit = new boolean[x+2][y+2];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;
        
        int value = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx > x + 1 || ny > y + 1)
                    continue;
                
                if(visit[nx][ny]) continue;
                
                // 빈 공간이면 이동
                if(map[nx][ny] == 0 || taked[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visit[nx][ny] = true;
                }

                // 요청 컨테이너면 제거 후보
                else if(map[nx][ny] == request && !check[nx][ny]){
                    check[nx][ny] = true;
                    value++;
                }
            }
        }
        
        for(int i = 1; i<=x; i++){
            for(int j = 1; j<=y; j++){
                if(check[i][j])
                    taked[i][j] = true;
            }
        }
        
        // 잔여 컨테이너 수 갱신
        size -= value;
    }
    public static void crane(char request){
        int value = 0;
        
        for(int i = 1; i<=x; i++){
            for(int j = 1; j<=y; j++){
                // 이미 꺼내진 컨테이너는 스킵
                if(taked[i][j]) continue;
                
                // 크레인이므로 요청에 해당하는 컨테이너면 바로 꺼내기
                if(map[i][j] == request){
                    taked[i][j] = true;
                    value++;
                }
            }
        }
        
        size -= value;
    }
}