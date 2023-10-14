import java.util.*;
import java.io.*;


public class Main {


    public static int[][] meeting;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 회의의 수

        meeting = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1;
        for(int i = 0; i<n; i++){
            if(meeting[i][0] >= end){
                end = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}