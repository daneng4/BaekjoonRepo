import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] nodes;
    private static int answer = 0;
    private static int deleteNode = 0;
    public static void main(String args[]) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n];

        for(int i = 0; i<n; i++) {
            nodes[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) {
                root = i;
                continue;
            }

            nodes[node].add(i);
        }

        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode == root) {
            System.out.println(0);
            return;
        }

        delete(root);
        dfs(root);

        System.out.println(answer);
    }
    private static void dfs(int node) {
        int size = nodes[node].size();
        if(size == 0) {
            answer += 1;
            return;
        }

        for(int i = 0; i<size; i++){
            int next = nodes[node].get(i);
            dfs(next);
        }
    }

    private static void delete(int node){
        int size = nodes[node].size();
        if(size == 0){
            return;
        }

        for(int i = 0; i<size; i++){
            int next = nodes[node].get(i);
            if(next == deleteNode){
                nodes[node].remove(i);
                break;
            }else{
                delete(next);
            }
        }
    }
}
