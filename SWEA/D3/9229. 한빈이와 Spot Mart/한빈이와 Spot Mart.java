
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
        	int[] s = new int[n];
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i<n; i++) {
        		s[i] = Integer.parseInt(st.nextToken());
        	}
        	Arrays.sort(s);
        	int start = 0; int end = s.length-1;
        	int answer = -1;
        	while(start < end) {
        		int sum = s[start] + s[end];
        		
        		if(sum == m) {
        			answer = sum;
        			break;
        		}else if (sum > m) {
        			end -= 1;
        		}else {
        			answer = Math.max(answer, sum);
        			start += 1;
        		}
        	}
        	
    		bw.write(String.format("#%d %d\n", t, answer));
        }
        bw.flush();
    }
}