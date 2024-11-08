import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        int answerA = 0;
        int answerB = 0;

        while (start < end) {
            int mid = arr[start] + arr[end];
            if (Math.abs(mid) < minDiff) {
                minDiff = Math.abs(mid);
                answerA = arr[start];
                answerB = arr[end];

                if (mid == 0) {
                    break;
                }
            }
            if (mid < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answerA + " " + answerB);
    }
}