import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<int[]> sq;
    static Queue<int[]> nq;
    static ArrayList<int[]> nwater;
    static ArrayList<int[]> water;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        sq = new ArrayList<>(); // 백조1이 갈 좌표 저장
        nq = new ArrayDeque<>();
        water = new ArrayList<>();
        nwater = new ArrayList<>();
        visit = new boolean[R][C];

        for(int i = 0; i<R; i++){
            String str = br.readLine();
            for(int j = 0; j<C; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'L'){
                    sq.add(new int[] {i, j});
                }

                if(map[i][j] == '.' || map[i][j] == 'L'){
                    water.add(new int[] {i,j});
                }
            }
        }

        int day = 0;
        // 백조가 서로 만날 수 있으면 종료한다
        while(!canMeet()){
            // 만날 수 없다면 얼음 녹인다
            melt();
            day++;
        }

        System.out.println(day);
    }
    public static boolean canMeet(){
        Queue<int[]> q = new ArrayDeque<>();

        if(nq.isEmpty()){
            q.add(new int[] {sq.get(0)[0], sq.get(0)[1]});
            visit[sq.get(0)[0]][sq.get(0)[1]] = true;
        }else{
            q.addAll(nq);
            nq.clear();
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0]; int curY = cur[1];

            if(curX == sq.get(1)[0] && curY == sq.get(1)[1]){
                return true;
            }

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny])
                    continue;

                visit[nx][ny] = true;

                if(map[nx][ny] == 'X'){
                    nq.add(new int[] {nx, ny});
                    continue;
                }

                q.add(new int[] {nx, ny});
            }
        }

        return false;
    }

    public static void melt(){
        for(int[] cur : water){

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                if(map[nx][ny] == 'X'){
                    nwater.add(new int[] {nx, ny});
                    map[nx][ny] = '.';
                }
            }
        }

        water.clear();
        water.addAll(nwater);
        nwater.clear();
    }
}