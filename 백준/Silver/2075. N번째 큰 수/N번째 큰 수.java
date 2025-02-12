import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	int n = Integer.parseInt(br.readLine());
    	
    	
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<n; j++) {
    			pq.add(Integer.parseInt(st.nextToken()));
    		}
    	}
    	
    	while(n -- > 1) {
    		pq.poll();
    	}
    	
    	System.out.println(pq.poll());
	}
}