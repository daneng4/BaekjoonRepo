import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> hList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    hList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(hList);
        System.out.println(hList.size());
        for (int h : hList) {
            System.out.println(h);
        }
    }

    static int bfs(int x, int y) {
        int hCount = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curX = poll[0];
            int curY = poll[1];
            hCount += 1;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] != 1) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }

        }

        return hCount;
    }
}