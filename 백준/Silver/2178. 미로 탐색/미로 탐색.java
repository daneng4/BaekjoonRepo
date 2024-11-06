import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = bfs(0, 0);
        System.out.println(answer);
    }

    static int bfs(int x, int y) {
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(x, y, 1));
        visited[x][y] = true;
        int minCount = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Move poll = q.poll();
            if (poll.posX == n - 1 && poll.posY == m - 1) {
                minCount = Math.min(poll.count, minCount);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.posX + dx[i];
                int nextY = poll.posY + dy[i];
                if (nextX >= n || nextY >= m || nextX < 0 || nextY < 0) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] != 1) {
                    continue;
                }

                q.add(new Move(nextX, nextY, poll.count + 1));
                visited[nextX][nextY] = true;
            }

        }

        return minCount;
    }
}

class Move {

    int posX;
    int posY;
    int count;

    public Move(int posX, int posY, int count) {
        this.posX = posX;
        this.posY = posY;
        this.count = count;
    }
}