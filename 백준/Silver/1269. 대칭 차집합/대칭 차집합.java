
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<m; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	int answer = 0;
    	for(int key : map.keySet()) {
    		if(map.get(key) == 1) {
    			answer += 1;
    		}
    	}
    	
    	System.out.println(answer);
    }
}