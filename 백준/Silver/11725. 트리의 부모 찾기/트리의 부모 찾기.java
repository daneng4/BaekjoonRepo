import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        parent = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        for(int i = 2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int node){
        visit[node] = true;

        for(int i : list[node]){
            if(!visit[i]){
                parent[i] = node;
                dfs(i);
            }
        }
    }
}