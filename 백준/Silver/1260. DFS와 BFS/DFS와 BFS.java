import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[] visit;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        for(int i = 1; i<=n; i++){
            visit[i] = false;
        }

        bfs(v);
        System.out.println(sb.toString());
    }
    public static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");

        for(int i = 1; i<=n; i++){
            if(graph[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }

    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            visit[cur] = true;
            sb.append(cur).append(" ");

            for(int i = 1; i<=n; i++){
                if(graph[cur][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }

            }
        }


    }
}
