
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int tc = 10;
    	
    	for(int t = 1; t<=tc; t++) {
    		int[][] map = new int[100][100];
    		int testNum = Integer.parseInt(br.readLine());
    		
    		int answer = 0;
    		int sum = 0;
    		for(int i = 0; i<100; i++){
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			sum = 0;
    			for(int j = 0; j<100; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    				// 행의 합 구할 수 있다.
    				sum += map[i][j];
    			}
    			answer = Math.max(answer, sum);
    		}
    		
    		for(int i = 0; i<100; i++) {
    			sum = 0;
    			for(int j = 0; j<100; j++) {
    				sum+= map[j][i];
    			}
    			answer = Math.max(answer, sum);
    		}
    		
    		sum = 0;
    		for(int i = 0; i<100; i++) {
    			sum += map[0+i][0+i];
    		}
    		answer = Math.max(answer, sum);
    		sum = 0;
    		for(int i = 0; i<100; i++) {
    			sum += map[0+i][99-i];
    		}
    		answer = Math.max(answer, sum);
    		
    		bw.write(String.format("#%d %d\n", testNum, answer));
    	} // end of testcase
    	bw.flush();
    }
}