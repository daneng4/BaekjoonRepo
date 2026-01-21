import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] possible;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static boolean canEscape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        possible = new boolean[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(possible[i][j] || visit[i][j]){
                    continue;
                }

                canEscape = false;
                escape(i, j);
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(possible[i][j])
                    answer++;
            }
        }

        System.out.println(answer);
    }
    public static void escape(int x, int y){
        // 맵 밖을 탈출하면
        if(x < 0 || y < 0 || x >= N || y >= M){
            canEscape = true;
            return;
        }

        if(possible[x][y]){
            possible[x][y] = true;
            canEscape = true;
            return;
        }

        if(visit[x][y])
            return;

        visit[x][y] = true;

        if(map[x][y] == 'U'){
            escape(x + dx[0], y + dy[0]);
        }else if(map[x][y] == 'R'){
            escape(x + dx[1], y + dy[1]);
        }else if(map[x][y] == 'D'){
            escape(x + dx[2], y + dy[2]);
        }else{
            escape(x + dx[3], y + dy[3]);
        }

        if(canEscape){
            possible[x][y] = true;
        }
    }
}