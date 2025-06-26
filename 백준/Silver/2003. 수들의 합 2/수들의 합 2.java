import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        while(true) {
        	if(sum >= m) {
        		sum = sum - arr[start++];
        	} else if(arr.length == end)
        		break;
        	else {
        		sum = sum + arr[end++];
        	}
        	
        	if(sum == m)
        		answer++;
        }
        
        System.out.println(answer);
    }
}