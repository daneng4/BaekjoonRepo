import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int[] far = new int[n-1]; // 도시 사이의 거라
        int[] cost = new int[n]; // 각 도시의 기름값
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n-1; i++){
            far[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            if(cost[i] < min)
                min = cost[i];
        }

        for(int i = 0; i<n-1; i++){
            if(cost[i] < cost[i+1]) {
                result += cost[i] * (far[i] + far[i + 1]);
                i+=1;
            }
            else
                result += cost[i] * far[i];
        }
        System.out.println(result);

    }
}