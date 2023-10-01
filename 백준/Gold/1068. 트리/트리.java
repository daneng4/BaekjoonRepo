import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static ArrayList<Integer>[] tree;
    static int leafNode = 0;
    static int deleteNode = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];

        int rootNode = 0;

        for(int i = 0; i<n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) // -1을 입력받은 인덱스가 루트노드
                rootNode = i;
            else
                tree[num].add(i);
        }
        deleteNode = Integer.parseInt(br.readLine()); // 삭제 노드

        if(deleteNode == rootNode){
            System.out.println(0);
            exit(0);
        }
        delete(rootNode);
        dfs(rootNode);

        System.out.println(leafNode);

    }

    static void dfs(int node){
//        if(node == deleteNode) { // 해당 노드가 삭제 노드일 경우
//            return;
//        }
        int size = tree[node].size();
        if(size == 0) // 노드 내에 값이 없다 = 리프 노드
            leafNode+=1;
        for(int i = 0; i<size; i++){
            int nextNode = tree[node].get(i);
            dfs(nextNode);
        }
    }

    static void delete(int node){
        int size = tree[node].size();
        if(size == 0)
            return;

        for(int i = 0; i<size; i++){
            int nextNode = tree[node].get(i);
            if(nextNode==deleteNode){
                tree[node].remove(i);
                break;
            }else{
                delete(nextNode);
            }
        }
    }
}
