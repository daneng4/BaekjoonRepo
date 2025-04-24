import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n+1];
		// union find 각 원소 부모 초기화
		for(int i = 1; i<=n; i++){
			parent[i] = i;
		}

		for(int i = 1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++){
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1){
					union(i,j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i = 1; i<m; i++){
			int now = Integer.parseInt(st.nextToken());

			if (start != find(now)) {
				System.out.println("NO\n");
				return;
			}
		}

		System.out.println("YES");

	}
	// union -> y의 부모를 x의 부모로 치환
	static void union(int x, int y){
		x = find(x);
		y = find(y);

		if(x != y){
			if(x < y){
				parent[y] = x;
			}else{
				parent[x] = y;
			}
		}
	}
	// find -> x의 부모(루트노드)를 찾음
	static int find(int x){
		if(x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}
}
