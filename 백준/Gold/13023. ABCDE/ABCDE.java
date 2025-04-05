import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static boolean possible = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n];
        for(int i = 0; i<n; i++){
            map[i] = new ArrayList<>();
        }

        visit = new boolean[n];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        for(int i = 0; i<n; i++){
            dfs(i, 1);
        }

        System.out.println(possible ? "1" : "0");
    }
    static void dfs(int node, int depth){
        if(depth == 5 | possible){
            possible = true;
            return;
        }

        visit[node] = true;
        for(int next : map[node]){
            if(visit[next])
                continue;
            dfs(next, depth + 1);
        }

        visit[node] = false;
    }
}
