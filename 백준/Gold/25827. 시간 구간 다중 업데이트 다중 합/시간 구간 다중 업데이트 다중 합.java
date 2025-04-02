import java.io.*;
import java.util.*;

public class Main {
    // 23시 59분 59초 -> 4,971,599초
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 4971599;
        long[] second = new long[max+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");

            int sSecond = convert(start);
            int eSecond = convert(end);

            if(op == 1){
                for(int j = sSecond; j<eSecond; j++){
                    second[j] += 1;
                }
            }else{
                long sum = 0;
                for(int j = sSecond; j<eSecond; j++){
                    sum += second[j];
                }
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);
    }
    public static int convert(String[] strs) {
        int second = 0;

        second += Integer.parseInt(strs[0]) * 60 * 60;
        second += Integer.parseInt(strs[1]) * 60;
        second += Integer.parseInt(strs[2]);

        return second;
    }
}
