import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] far;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        far = new int[n+1];

        for(int i = 2; i<=n; i++){
            far[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i<=m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, 0);
        int answer = 0;
        for(int i = 2; i<=n ;i++){
            if(far[i] < 3)
                answer += 1;
        }

        System.out.println(answer);
    }

    static void dfs(int node, int count){
        if(visit[node] || count > 2)
            return;

        visit[node] = true;

        for(int next : list[node]){
            far[next] = Math.min(far[next], count+1);
            dfs(next, count + 1);
        }

        visit[node] = false;
    }
}
