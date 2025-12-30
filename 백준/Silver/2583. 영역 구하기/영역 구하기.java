import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static ArrayList<Integer> list;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        list = new ArrayList<>();

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y<y2; y++){
                for(int x = x1; x<x2; x++){
                    map[y][x] = true;
                }
            }
        }

        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j]) continue;
                bfs(i,j);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int size : list){
            sb.append(size).append(" ");
        }

        System.out.println(sb);
    }
    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        map[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            Point point = q.poll();

            for(int i = 0; i<4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && !map[nx][ny]){
                    count+=1;
                    q.add(new Point(nx,ny));
                    map[nx][ny] = true;
                }
            }
        }

        list.add(count);
    }
}