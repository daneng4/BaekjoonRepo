import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i<n; i++){
            String s = br.readLine();
            for(int j = 0; j<n; j++){
                if(s.charAt(j) == '#'){
                    map[i][j] = 9;
                    continue;
                }

                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<n-1; j++){

                check(i, j);
            }
        }

        System.out.println(answer);
    }
    public static void check(int x, int y){
        int[] dx = {1,-1,0,0,1,1,-1,-1};
        int[] dy = {0,0,1,-1,1,-1,1,-1};
        boolean can = true;

        for(int i = 0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;

            if(map[nx][ny] == 0){
                can = false;
                break;
            }
        }

        if(can){
            for(int i = 0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                map[nx][ny] -= 1;
            }

            answer += 1;
        }
    }
}
