import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        int gox = 0; int goy = 0;

        for(int i = 0; i<R; i++){
            String str = br.readLine();

            for(int j = 0; j<C; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'S'){
                    gox = i;
                    goy = j;
                }
            }
        }

        int answer = bfs(gox, goy);

        if(answer == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(answer);
        }
    }
    public static int bfs(int gox, int goy){
        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(gox, goy, 0));
        visit[gox][goy] = true;

        while(!q.isEmpty()){
            // 물 전파 위치 파악
            water();

            int loof = q.size();

            for(int j = 0; j<loof; j++){
                // 고슴도치 다음 갈 수 있는 곳 파악
                Info info = q.poll();

                if(map[info.x][info.y] == 'D')
                    return info.time;

                for(int i = 0; i<4; i++){
                    int nx = info.x + dx[i];
                    int ny = info.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                        continue;

                    if(map[nx][ny] == 'X' || visit[nx][ny] || map[nx][ny] == '*')
                        continue;

                    q.add(new Info(nx, ny, info.time + 1));
                    visit[nx][ny] = true;
                }
            }
        }

        return -1;
    }
    public static void water(){
        Queue<int[]> q2 = new ArrayDeque<>();

        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(map[i][j] == '*'){
                    q2.add(new int[] {i, j});
                }
            }
        }

        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int i = 0; i<4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                if(map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D')
                    continue;

                map[nx][ny] = '*';
            }
        }

    }
}
class Info {
    int x;
    int y;
    int time;
    public Info(int x, int y, int time){
        this.x = x; this.y = y; this.time = time;
    }
}