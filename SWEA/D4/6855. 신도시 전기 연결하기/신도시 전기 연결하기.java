import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	PriorityQueue<Integer> pq = new PriorityQueue<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	int[] num = new int[n];
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i<n; i++) {
        		num[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i = 0; i<n-1; i++) {
        		pq.add(num[i+1] - num[i]);
        	}
        	int answer = 0;
        	
        	if(n <= k)
        		bw.write(String.format("#%d 0\n", tc));
        	else {
        		for(int i = 0; i<n - k; i++) {
        			answer += pq.poll();
        		}
        		bw.write(String.format("#%d %d\n", tc, answer));
        	}
        	
        }// tc
        bw.flush();
    }
}
