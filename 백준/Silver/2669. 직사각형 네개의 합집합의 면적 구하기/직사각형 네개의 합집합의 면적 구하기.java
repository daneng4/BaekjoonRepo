import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 4;
        boolean[][] map = new boolean[101][101];
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());

            int leftx = Integer.parseInt(st.nextToken());
            int lefty = Integer.parseInt(st.nextToken());
            int rightx = Integer.parseInt(st.nextToken());
            int righty = Integer.parseInt(st.nextToken());

            for(int i = leftx; i<rightx; i++){
                for(int j = lefty; j< righty; j++){
                    if(map[i][j])
                        continue;
                    map[i][j] = true;
                }
            }

        }

        int answer = 0;
        for(int i = 1; i<=100; i++){
            for(int j = 1; j<=100; j++){
                if(map[i][j])
                    answer += 1;
            }
        }

        System.out.println(answer);
    }
}
