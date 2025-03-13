import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static boolean success;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];

        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        success = false;
        process(1,1);
        if(success){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }
    static void process(int x, int y){
        if(x > n || y > n || visit[x][y]){
            return;
        }

        if(map[x][y] == -1){
            success = true;
            return;
        }

        visit[x][y] = true;

        // down
        process(x + map[x][y], y);

        // right
        process(x, y + map[x][y]);
    }
}
