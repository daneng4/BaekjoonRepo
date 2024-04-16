
import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int k;
	static int[] num;
	static int answer;
	static boolean[] visit;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int tc = Integer.parseInt(br.readLine());

    	for(int t = 1; t<=tc; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		k = Integer.parseInt(st.nextToken());
    		
    		num = new int[n];
    		visit = new boolean[n];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i<n; i++) {
    			num[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		answer = 0;
    		solve(0, 0);
    		
    		bw.write(String.format("#%d %d\n", t, answer));
    	} // end of tc
    	bw.flush();
    }
    public static void solve(int sum, int depth) {
    	if(depth == n) {
    		if(sum == k)
    			answer++;
    		return;
    	}else {
    		solve(sum, depth+1);
    		solve(sum + num[depth], depth+1);
    	}
    	
    }
}