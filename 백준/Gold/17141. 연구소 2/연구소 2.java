import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int minTime = Integer.MAX_VALUE;
    static int walls = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        LinkedList<int[]> viruses = new LinkedList<>();
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    walls++;
            }
        }

        selectVirusSection(0, viruses, 0);

        if(minTime == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minTime);
    }

    private static void selectVirusSection(int selected, LinkedList<int[]> viruses, int pi){
        if(selected == M){
            moveVirus(viruses);
            return;
        }

        for(int i = pi; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 2 && !visited[i][j]){
                    viruses.add(new int[] {i,j});
                    visited[i][j] = true;
//                    if(j+1 < N){
//                        selectVirusSection(selected + 1, viruses, i, j+1);
//                    }else{
//                        selectVirusSection(selected + 1, viruses, i+1, 0);
//                    }
                    selectVirusSection(selected + 1, viruses, i);
                    viruses.pollLast();
                    visited[i][j] = false;
                }
            }
        }

    }

    private static void moveVirus(LinkedList<int[]> viruses){
        int time = 0;
        int moved = viruses.size();

        boolean[][] virusMoved = new boolean[N][N];
        Queue<Virus> q = new LinkedList<>();

        for(int[] vp : viruses){
            virusMoved[vp[0]][vp[1]] = true;
            q.add(new Virus(vp[0], vp[1], 0));
        }

        while(!q.isEmpty()){
            Virus cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            time = Math.max(time, cur.time);

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 맵을 안 벗어나며 이미 방문한 곳이 아니고 벽(1)도 아닌 곳
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if(virusMoved[nx][ny])
                    continue;

                if(map[nx][ny] == 1)
                    continue;

                q.add(new Virus(nx, ny, cur.time + 1));
                virusMoved[nx][ny] = true;
                moved++;
            }
        }

        if(N*N - walls == moved){
            minTime = Math.min(minTime, time);
        }
    }

    public static class Virus{
        int x;
        int y;
        int time;
        public Virus(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static boolean check(boolean[][] virusMoved){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 1)
                    continue;

                if(!virusMoved[i][j])
                    return false;
            }
        }

        return true;
    }
}
