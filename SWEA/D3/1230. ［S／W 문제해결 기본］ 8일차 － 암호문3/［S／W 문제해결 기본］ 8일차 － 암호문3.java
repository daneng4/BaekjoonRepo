
import java.util.*;
import java.io.*;
 
public class Solution {
	static LinkedList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int testCase = 10;
        
        for(int t = 1; t<=testCase; t++) {
        	int codeLen = Integer.parseInt(br.readLine());
        	list = new LinkedList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i<codeLen; i++) {
        		list.add(st.nextToken());
        	}
        	
        	int opLen = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	task(opLen, st);
        	
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i<10; i++) {
        		sb.append(list.get(i)).append(" ");
        	}
        	
        	bw.write(String.format("#%d %s\n", t, sb.toString()));
        }
        
        bw.flush();
        
    }
    public static void task(int opLen, StringTokenizer st) {
    	for(int i = 0; i<opLen; i++) {
    		String op = st.nextToken();
    		
    		if(op.equals("I")) {
    			int pos = Integer.parseInt(st.nextToken());
        		int numsize = Integer.parseInt(st.nextToken());
    			for(int j = 0; j<numsize; j++) {
        			list.add(pos++, st.nextToken());
        		}
    		}else if (op.equals("D")) {
    			int pos = Integer.parseInt(st.nextToken());
    			int numsize = Integer.parseInt(st.nextToken());
    			for(int j = 0; j<numsize; j++) {
    				list.remove(pos);
    			}
    		}else {
    			int numsize = Integer.parseInt(st.nextToken());
    			for(int j = 0; j<numsize; j++) {
    				list.addLast(st.nextToken());
    			}
    		}
        	
    	}
    	
    }
}