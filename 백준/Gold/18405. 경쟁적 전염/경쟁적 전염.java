import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int n,s;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    public static void main(String args[]) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        map = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num != 0)
                    pq.add(new Virus(num, i, j, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bfs(pq);

        System.out.println(map[x][y]);
    }
    private static void bfs(PriorityQueue<Virus> pq){
        while(!pq.isEmpty()){
            Virus cuv = pq.poll();
            if(cuv.second == s){
                return;
            }

            for(int i = 0; i<4; i++){
                int nextx = cuv.x + dx[i];
                int nexty = cuv.y + dy[i];

                if(nextx >= 1 && nextx <= n && nexty >= 1 && nexty <= n){
                    if(map[nextx][nexty] == 0){
                        map[nextx][nexty] = cuv.num;
                        pq.add(new Virus(cuv.num, nextx, nexty, cuv.second + 1));
                    }
                }

            }
        }
    }
}
class Virus implements Comparable<Virus>{
    int num;
    int x;
    int y;
    int second;
    public Virus(int num, int x, int y, int second){
        this.num = num;
        this.x = x;
        this.y = y;
        this.second = second;
    }

    @Override
    public int compareTo(Virus V){
        if(this.second == V.second){
            return this.num - V.num;
        }
        return this.second - V.second;
    }
}
