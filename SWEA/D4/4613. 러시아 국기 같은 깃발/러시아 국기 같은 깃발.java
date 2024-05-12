import java.util.*;
import java.io.*;

public class Solution {
	static char[][] map;
	static int n,m;
	static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            
            for(int i = 0; i<n; i++) {
            	String str = br.readLine();
            	for(int j = 0; j<m; j++) {
            		map[i][j] = str.charAt(j);
            	}
            }
            
            Queue<flag> q = new LinkedList<>();
            // 0번째 줄은 무조건 W색이어야 함
            
            // 흰 파 빨 순서대로 비율 정하기
            // 파, 빨이 무조건 1개 이상 들어가야하므로 w는 n-2까지
            for(int w = 0; w<n-2; w++) {
            	// 빨이 무조건 1개 이상 들어가야하므로 b는 n-1까지
            	for(int b = w+1; b<n-1; b++) {
        			q.add(new flag(w,b));
            	}
            }
            
            answer = Integer.MAX_VALUE;
            solve(q);
            
            bw.write(String.format("#%d %d\n", tc, answer));
        }// tc
        
        bw.flush();
    }
    public static void solve(Queue<flag> q) {
    	while(!q.isEmpty()) {
    		int total = 0;
    		flag poll = q.poll();
    		int wRange = poll.w;
    		int bRange = poll.b;
    		
    		// 흰색 검사
    		for(int i = 0; i<=wRange; i++) {
    			for(int j = 0; j<m; j++) {
    				if(map[i][j] != 'W')
    					total++;
    			}
    		}
    		// 파랑 검사
    		for(int i = wRange+1; i<=bRange; i++) {
    			for(int j = 0; j<m; j++) {
    				if(map[i][j] != 'B')
    					total++;
    			}
    		}
    		// 빨강 검사
    		for(int i = bRange+1; i<n; i++) {
    			for(int j = 0; j<m; j++) {
    				if(map[i][j] != 'R')
    					total++;
    			}
    		}
    		
    		// 최소값 갱신
    		answer = Math.min(answer, total);
    	}
    }

}
class flag{
	int w;
	int b;
	flag(int w, int b){
		this.w = w; this.b = b;
	}
}