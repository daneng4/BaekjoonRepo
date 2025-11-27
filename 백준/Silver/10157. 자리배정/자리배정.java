import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[][] array = new boolean[R+1][C+1];
        if(C * R < K){
            System.out.println(0);
            return;
        }

        int number = 1;
        int sx = R;
        int sy = 1;
        int dv = 0;

        // K에 도달하면 종료
        while(number != K){
            // 배열을 순회하는 로직 필요
            array[sx][sy] = true;
            int nx = sx + dx[dv];
            int ny = sy + dy[dv];

            // 다음 좌표가 array 바깥이거나 이미 방문한 곳이라면 방향벡터를 바꿔준다
            if(nx <= 0 || ny <= 0 || nx > R || ny > C || array[nx][ny]){
                dv = (dv + 1) % 4;
                nx = sx + dx[dv];
                ny = sy + dy[dv];
            }

            sx = nx;
            sy = ny;

            number++;
        }

        System.out.println(sy + " " + (R-sx+1));
    }
}