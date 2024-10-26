
import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static int chance;
	static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1; i<=testcase; i++) {
        	st = new StringTokenizer(br.readLine());
        	String number = st.nextToken();
        	chance = Integer.parseInt(st.nextToken());
        	arr = new int[number.length()];
        	max = 0;

        	for(int j = 0; j<arr.length; j++) {
        		arr[j] = number.charAt(j) - '0';
        	}
        	
        	if(arr.length < chance) {
        		chance = arr.length;
        	}
        	
        	dfs(0);
        	bw.write(String.format("#%d %d\n", i, max));
        }
        bw.flush();
        bw.close();
        
    }
    public static void dfs(int depth) {
    	// 교환 횟수만큼 교환 했으면 최대값과 현재값을 비교
    	if(depth == chance) {
    		int sum = 0;
    		for(int i = 0; i<arr.length; i++) {
    			sum += (Math.pow(10, i) * arr[arr.length - i - 1]);
    		}
    		
    		max = Math.max(max, sum);
    		return;
    	}
    	
    	for(int i = 0; i<arr.length; i++) {
    		for(int j = i+1; j<arr.length; j++) {
    			swap(i,j);
    			dfs(depth + 1);
    			swap(i,j);
    		}
    	}
    	
    }
    public static void swap(int x, int y) {
    	int temp = arr[x];
    	arr[x] = arr[y];
    	arr[y] = temp;
    }
}