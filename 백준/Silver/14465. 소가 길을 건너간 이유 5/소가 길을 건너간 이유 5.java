import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] broken = new boolean[n+1];

        for(int i = 0; i<k; i++) {
            int idx = Integer.parseInt(br.readLine());
            broken[idx] = true;
        }

        int s = 1;
        int e = b;
        int count = 0;

        for(int i = s; i<=e; i++){
            if(broken[i])
                count += 1;
        }

        int answer = count;
        while(e < n){
            if(broken[s])
                count -= 1;
            s+=1;
            e+=1;
            if(broken[e]){
                count += 1;
            }

            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
