import java.io.*;
import java.util.*;

public class Main {
	static final int max = 100001;
	static int[] parent = new int[100001];
	static int[] time = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		time[n] = 1;
		q.add(n);

		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur == k){
				stack.push(k);
				int idx = k;

				while(idx != n){
					stack.push(parent[idx]);
					idx = parent[idx];
				}

				break;
			}

			for(int i = 0; i<3; i++){
				int next;
				if(i == 0) next = cur * 2;
				else if(i == 1) next = cur + 1;
				else next = cur - 1;

				if(0 <= next && next < max){
					if(time[next] == 0){
						q.add(next);
						time[next] = time[cur] + 1;
						parent[next] = cur;
					}
				}

			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(time[k] - 1 + "\n");
		while(!stack.isEmpty()){
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);

	}
}
