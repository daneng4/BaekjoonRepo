import java.io.*;
import java.util.*;

public class Main {
	static int[] map;
	static int max = 100001;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[max];

		int result = bfs(n);
		System.out.println(result);
	}
	static int bfs(int n){
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		map[n] = 1;

		while(!q.isEmpty()){
			int pos = q.poll();

			if(pos == k){
				return map[pos] - 1;
			}

			if(0 <= pos - 1 && map[pos-1] == 0){
				map[pos-1] = map[pos] + 1;
				q.add(pos-1);
			}
			if(pos + 1 < max && map[pos+1] == 0){
				map[pos+1] = map[pos] + 1;
				q.add(pos+1);
			}
			if(pos * 2 < max && map[pos * 2] == 0){
				map[pos * 2] = map[pos] + 1;
				q.add(pos * 2);
			}
		}

		return -1;
	}
}
