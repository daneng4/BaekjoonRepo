
import java.io.*;
import java.util.*;

public class Main {
	public static int bro;
	public static int[] point;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin = Integer.parseInt(st.nextToken());
		bro = Integer.parseInt(st.nextToken());
		point = new int[100001];
		int result = bfs(subin);
		System.out.println(result);
	}
	public static int bfs(int subin) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(subin);
		point[subin] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == bro) {
				return point[now]-1;
			}
			if(now-1 >= 0 && point[now-1] == 0) {
				point[now-1] = point[now]+1;
				q.offer(now-1);
			}
			if(now+1 < 100001 && point[now+1] == 0){
				point[now+1] = point[now]+1;
				q.offer(now+1);
			}
			if(now*2<100001 && point[now*2] == 0) {
				point[now*2] = point[now]+1;
				q.offer(now*2);
			}
		}
		return -1;
	}
}
