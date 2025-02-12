import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Integer> negQ = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> posQ = new PriorityQueue<>(Collections.reverseOrder());
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		int element = Integer.parseInt(st.nextToken());
    		if(element < 0)
    			negQ.add(Math.abs(element));
    		else
    			posQ.add(element);
    	}
    	
    	int max = 0;
    	if(negQ.isEmpty()) {
    		max = posQ.peek();
    	}else if(posQ.isEmpty()) {
    		max = negQ.peek();
    	}else {
    		max = Math.max(posQ.peek(), negQ.peek());
    	}
    	
    	int answer = 0;
    	while(!posQ.isEmpty()) {
    		int temp = posQ.poll();
    		for(int i = 0; i<m-1; i++) {
    			posQ.poll();
    			
    			if(posQ.isEmpty()) {
    				break;
    			}
    		}
    		answer += temp * 2;
    	}
    	
    	while(!negQ.isEmpty()) {
    		int temp = negQ.poll();
    		for(int i = 0; i<m-1; i++) {
    			negQ.poll();
    			
    			if(negQ.isEmpty()) {
    				break;
    			}
    		}
    		answer += temp * 2;
    	}
    	
    	answer -= max;
    	System.out.println(answer);
	}
}