import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] data = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            start = Math.min(start, L);
            end = Math.max(end, L);

            data[L] = H;
        }

        Stack<Integer> height = new Stack<>();
        int temp = data[start];
        for(int i = start + 1; i<=end; i++){
            // 현재 높이가 temp보다 작은 경우
            if(data[i] < temp){
                height.push(i);
            }
            // 현재 높이가 temp보다 크거나 같은 경우
            else{
                while(!height.isEmpty()){
                    int x = height.pop();
                    data[x] = temp;
                }
                temp = data[i];
            }
        }

        height.clear();
        temp = data[end];
        for(int i = end - 1; i>= start; i--){
            if(data[i] < temp)
                height.push(i);
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    data[x] = temp;
                }
                temp = data[i];
            }
        }

        int answer = 0;
        for(int i = start; i<=end; i++)
            answer += data[i];

        System.out.println(answer);
    }
}
