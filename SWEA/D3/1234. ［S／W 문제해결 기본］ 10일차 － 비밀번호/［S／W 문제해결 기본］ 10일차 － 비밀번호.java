
import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int testCase = 10;
        
        for(int t = 1; t<=testCase; t++) {
        	Deque<Character> dq = new LinkedList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int len = Integer.parseInt(st.nextToken());
        	String pw = st.nextToken();
        	char[] arr = pw.toCharArray();
        	
        	for(int i = 0; i<len; i++) {
        		if(dq.isEmpty()) {
        			dq.add(arr[i]);
        			continue;
        		}
        		if(dq.peekLast() == arr[i])
        			dq.pollLast();
        		else
        			dq.add(arr[i]);
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	while(!dq.isEmpty()) {
        		sb.append(dq.poll());
        	}
        	
        	bw.write(String.format("#%d %s\n", t, sb.toString()));
        }
        bw.flush();
    }
}