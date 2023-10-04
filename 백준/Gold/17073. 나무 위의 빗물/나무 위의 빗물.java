import java.util.*;
import java.io.*;

public class Main  {

    static ArrayList<Integer>[] list;
    static int leaf = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int w = Integer.parseInt(st.nextToken()); // 고인 물의 양

        list = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 2; i<n+1; i++){
            if(list[i].size() == 1)
                leaf += 1;
        }

        System.out.println(String.format("%.10f", (double)w/leaf));

    }
}