
import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int testCase = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=testCase; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int[] snack = new int[n];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<n; i++) {
        		snack[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int answer = 0;
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<n; j++) {
        			if(i==j) continue;
        			int sum = snack[i] + snack[j];
        			if(sum <= m)
        				answer = Math.max(answer, sum);
        		}
        	}
        	if(answer == 0)
        		bw.write(String.format("#%d -1\n", t));
        	else
        		bw.write(String.format("#%d %d\n", t, answer));
        }
        bw.flush();
        
    }
}