import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        StringTokenizer st;

        int start = Integer.MAX_VALUE;
        int end = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            start = Math.min(start, l);
            end = Math.max(end, l);

            arr[l] = h;
        }

        Stack<Integer> height = new Stack<>();
        int temp = arr[start];
        for(int i = start + 1; i<= end; i++){
            if(arr[i] < temp){
                height.push(i);
            }else{
                while(!height.isEmpty()){
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        height.clear();

        temp = arr[end];
        for(int i = end-1; i >= start; i--){
            if(arr[i] < temp)
                height.push(i);
            else{
                while(!height.isEmpty()){
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        int answer = 0;
        for(int i = start; i<=end; i++)
            answer += arr[i];

        System.out.println(answer);
    }
}
