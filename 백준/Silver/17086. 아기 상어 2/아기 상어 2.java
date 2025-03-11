import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static class Info{
        int[] pos;
        int distance;
        public Info(int[] pos, int distance){
            this.pos = pos;
            this.distance = distance;
        }
    }
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        int[][] safeDistanceArr = new int[n][m];

        for(int i  = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1)
                    continue;
                int result = bfs(new int[] {i,j});
                safeDistanceArr[i][j] = result;
                visit = new boolean[n][m];
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                answer = Math.max(safeDistanceArr[i][j], answer);
            }
        }

        System.out.println(answer);
    }
    private static int bfs(int[] start){
        int safeDistance = Integer.MAX_VALUE;
        Queue<Info> info = new LinkedList<>();
        info.add(new Info(start, 0));
        visit[start[0]][start[1]] = true;

        while(!info.isEmpty()){
            Info now = info.poll();
            int nowx = now.pos[0];
            int nowy = now.pos[1];
            if(map[nowx][nowy] == 1){
                safeDistance = Math.min(safeDistance, now.distance);
            }

            for(int i = 0; i<8; i++){
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];

                if(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && !visit[nextx][nexty]){
                    info.add(new Info(new int[] {nextx, nexty}, now.distance + 1));
                    visit[nextx][nexty] = true;
                }
            }
        }

        return safeDistance;
    }
}
