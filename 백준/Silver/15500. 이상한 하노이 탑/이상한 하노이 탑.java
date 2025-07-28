import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	s1.add(Integer.parseInt(st.nextToken()));
        }
        
        int cnt = 0;
        int curNum = n;
        while(curNum != 0) {
        	if(s1.contains(curNum)) {
        		while(true) {
        			int num = s1.pop();
        			
        			if(num == curNum) {
        				curNum--;
        				sb.append("1 3\n");
        				cnt++;
        				break;
        			}else {
        				s2.add(num);
        				sb.append("1 2\n");
        				cnt++;
        			}
        		}	
        	}else {
        		while(true) {
        			int num = s2.pop();
        			
        			if(num == curNum) {
        				curNum--;
        				sb.append("2 3\n");
        				cnt++;
        				break;
        			}else {
        				s1.add(num);
        				sb.append("2 1\n");
        				cnt++;
        			}
        		}
        	}
        }
        
        System.out.println(cnt);
        System.out.println(sb);
    }
}