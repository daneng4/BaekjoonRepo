
import java.io.*;
import java.util.*;

public class Main {
	static int[] map;
	static int n,k;
	static int maxp = 100001;
	static int min = 987654321;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 수빈 위치
		k = Integer.parseInt(st.nextToken()); // 동생 위치

		if(n>=k) {
			System.out.println(n-k);
			System.out.println(1);
			return;
		}
		
		map = new int[maxp];
		
		bfs(n);
		System.out.println(min);
		System.out.println(count);
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		map[start] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(min < map[cur])
				return;
			
			for(int i = 0; i<3; i++) {
				int next;
				
				if(i == 0) next = cur - 1;
				else if(i == 1) next = cur + 1;
				else next = cur * 2;
				
				if(next < 0 || next >= maxp)
					continue;
				if(next == k) {
					min = map[cur];
					count++;
				}
				
				if(map[next] == 0 || map[next] == map[cur] + 1) {
					q.add(next);
					map[next] = map[cur]+1;
				}
			}
			
		}
		
	}
}