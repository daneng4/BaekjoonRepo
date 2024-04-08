
import java.io.*;
import java.util.*;

public class Main {
	
	static final int min = -1;
	static final int max = 100001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] map = new int[100001];
		boolean[] visit = new boolean[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int arr[] = {now-1,now+1, now-a,now+ a, now-b, now+b, now*a, now*b};
			for(int i = 0; i<8; i++) {
				if(arr[i] >=0 && arr[i] <= 100000 && !visit[arr[i]]) {
					visit[arr[i]] = true;
					map[arr[i]] = map[now]+1;
					q.add(arr[i]);
				}
			}
			if(map[m] > 0)
				break;
		}
		
		System.out.println(map[m]);
	}

}