import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = 10;
		
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testCaseNumber = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			visit = new boolean[100];
			list = new ArrayList[100];
			
			for(int i = 0; i<100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				list[start].add(end);
			}
			
			if(bfs(0, 99)) {
				bw.write(String.format("#%d 1\n", testCaseNumber));
			}else
				bw.write(String.format("#%d 0\n", testCaseNumber));
			
		} // testcase
		bw.flush();
			
	}
	public static boolean bfs(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == target)
				return true;
			
			if(visit[cur])
				continue;
			visit[cur] = true;
			
			for(int next : list[cur]) {
				q.add(next);
			}
			
		}
		
		return false;
	}
}
