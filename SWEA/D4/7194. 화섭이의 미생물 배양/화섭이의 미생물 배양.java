import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNumber = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= testNumber; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int target = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
       
        	// 반약 배수 b가 1이면
        	if(b == 1) {
        		int temp = target-start;
        		if(temp % a == 0) {
        			bw.write(String.format("#%d %d\n", tc, (target-start) / a));
        		}else
        			bw.write(String.format("#%d -1\n", tc));
        		continue;
        	}
        	
        	int count = 0;
        	while(target != start) {
        		if(target % b == 0) {
        			if(target / b < start) {
        				count++;
        				target -= a;
        			}else {
        				count++;
        				target /= b;
        			}
        		}else {
        			count++;
        			target -= a;
        		}
        		
        		if(target < start) {
        			count = -1;
        			break;
        		}
        	}
        	
        	bw.write(String.format("#%d %d\n", tc, count));
        }// tc
        bw.flush();
    }
}