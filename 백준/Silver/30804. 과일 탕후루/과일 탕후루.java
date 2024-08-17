
import java.util.*;
import java.io.*;

public class Main {
	static int[] cur, tang;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cur = new int[10];
        tang = new int[n];
        
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	tang[i] = num;
        }
        
        int left = 0;
        int right = 0;
        int max = 0;
        
        while(right < n) {
        	cur[tang[right++]] += 1;
        	
        	while(10 - count(cur) > 2) {
        		cur[tang[left++]] -= 1;
        	}
        	
        	max = Math.max(max, right-left);
        }
        
        System.out.println(max);
    }
	public static int count(int[] cur) {
		int result = 0;
		for(int c : cur) {
			if(c == 0)
				result+=1;
		}
		
		return result;
	}
}