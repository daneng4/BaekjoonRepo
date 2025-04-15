import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] nums = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        for(int i = 0; i<n; i++){
            nums[i] = Double.parseDouble(st.nextToken());
            max = Math.max(nums[i], max);
        }

        double sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i] / max * 100;
        }

        System.out.println(sum/n);
    }
}
