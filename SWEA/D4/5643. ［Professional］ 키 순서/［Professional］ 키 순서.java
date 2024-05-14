import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Integer>[] node;
	static ArrayList<Integer>[] reverse;
	static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	int n = Integer.parseInt(br.readLine()); // 정점 수
        	int m = Integer.parseInt(br.readLine());
        	node = new ArrayList[n+1];
        	reverse = new ArrayList[n+1];
        	visit = new boolean[n+1];
        	
        	for(int i = 1; i<=n; i++) {
        		node[i] = new ArrayList<>();
        		reverse[i] = new ArrayList<>();
        	}
        	
        	for(int i = 0; i<m; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		node[a].add(b);
        		reverse[b].add(a);
        	}
        	
        	int answer = 0;
        	
        	for(int i = 1; i<=n; i++) {
        		int total = n - 1; // 자기 자신 제외 학생 수
        		int count = 0;
        		Arrays.fill(visit, false);
        		count += checkHigh(i);
        		Arrays.fill(visit, false);
        		count += checkLow(i);
        		
        		if(total == count)
        			answer++;
        	}
        	
        	bw.write(String.format("#%d %d\n", tc, answer));
        }// tc
        bw.flush();
    }
    public static int checkHigh(int start) {
    	int count = 0;
    	// 나보다 키 큰 학생 수 체크
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		if(visit[cur]) continue;
    		visit[cur] = true;
    		count++;
    		for(int next : node[cur]) {
    			q.add(next);
    		}
    		
    	}
    	if(count > 0)
    		return count-1;
    	else
    		return 0;
    }
    public static int checkLow(int start) {
    	int count = 0;
    	// 나보다 키 작은 학생 수 체크
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		if(visit[cur]) continue;
    		visit[cur] = true;
    		count++;
    		for(int next : reverse[cur]) {
    			q.add(next);
    		}
    		
    	}
    	if(count > 0)
    		return count-1;
    	else
    		return 0;
    }
}