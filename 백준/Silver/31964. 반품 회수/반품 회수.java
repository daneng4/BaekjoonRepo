import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] location = new int[n];
        int[] time = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++) {
        	location[i] = Integer.parseInt(st1.nextToken());
        	time[i] = Integer.parseInt(st2.nextToken());
        }
        
        int answer = (location[n-1] < time[n-1] ? time[n-1] : location[n-1]);
        for(int i = n-2; i >= 0; i--) {
        	answer += location[i+1] - location[i];
        	if(answer < time[i])
        		answer = time[i];
        }
        
        answer += location[0];
        System.out.println(answer);
    }
}