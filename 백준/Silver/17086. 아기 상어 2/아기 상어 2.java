import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        q = new LinkedList<>();

        for(int i  = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new int[] {i,j,0});
                }else{
                    dist[i][j] = -1;
                }
            }
        }

        bfs();
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }
    private static void bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int ndist = now[2];

            for(int i = 0; i<8; i++){
                int nextx = x + dx[i];
                int nexty = y + dy[i];

                if(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && dist[nextx][nexty] == -1){
                    dist[nextx][nexty] = ndist + 1;
                    q.add(new int[] {nextx, nexty, ndist + 1});
                }
            }
        }
    }
}
