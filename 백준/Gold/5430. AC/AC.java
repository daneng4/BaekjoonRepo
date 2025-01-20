import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	
    	while(t-- > 0) {
    		String[] p = br.readLine().split("");
    		int n = Integer.parseInt(br.readLine());
    		Deque<Integer> list = new LinkedList<>();
    		
    		StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
    		for(int i = 0; i<n; i++) {
    			list.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		System.out.println(process(p, list));
    	}
    	
    	
	}
	public static String process(String[] command, Deque<Integer> list) {
		boolean isFirst = true;
		for(String c : command) {
			if(c.equals("R")) {
				isFirst = !isFirst;
			}else {
				if(list.size() == 0)
					return "error";
				
				if(isFirst) {
					list.pollFirst();
				}else {
					list.pollLast();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("[");
		while(!list.isEmpty()) {
			sb.append(!isFirst ? list.pollLast() : list.pollFirst());
			if(list.size() != 0) {
				sb.append(",");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}