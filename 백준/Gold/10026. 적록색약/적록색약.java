import java.io.*;
import java.util.*;

public class Main {

    static String[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int area = 0;
    static int area2 = 0;
    static int n;
    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i<n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j<n; j++){
                map[i][j] = str[j];
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visit[i][j])
                    normal(i, j);
            }
        }
        System.out.print(area + " ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j].equals("G"))
                    map[i][j] = "R";
            }
        }
        visit = new boolean[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visit[i][j])
                    special(i, j);
            }
        }
        System.out.println(area2);

    }
    public static void normal(int x, int y){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visit[x][y] = true;
        String color = map[x][y];

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i = 0; i<4; i++){
                int nextx = nowx+dx[i];
                int nexty = nowy+dy[i];

                if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= n)
                    continue;
                if(visit[nextx][nexty] || !map[nextx][nexty].equals(color))
                    continue;

                q.offer(new int[] {nextx,nexty});
                visit[nextx][nexty] = true;
            }

        }// end of while
        area++;
    }

    public static void special(int x, int y){
        Queue<int []> sq = new LinkedList<>();
        sq.offer(new int[] {x,y});
        visit[x][y] = true;
        String color = map[x][y];

        while(!sq.isEmpty()){
            int[] now = sq.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i = 0; i<4; i++){
                int nextx = nowx+dx[i];
                int nexty = nowy+dy[i];

                if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= n)
                    continue;
                if(visit[nextx][nexty] || !map[nextx][nexty].equals(color))
                    continue;

                sq.offer(new int[] {nextx,nexty});
                visit[nextx][nexty] = true;
            }

        }// end of while
        area2++;
    }
}
