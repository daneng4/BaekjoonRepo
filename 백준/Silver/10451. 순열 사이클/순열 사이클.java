import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n+1];
			visit = new boolean[n+1];

			for(int i = 1; i<=n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for(int i = 1; i<=n; i++){
				if(visit[i]) continue;
				dfs(i);
				count++;
			}

			System.out.println(count);
		}

	}
	public static void dfs(int node){
		if(visit[node]) return;

		visit[node] = true;
		dfs(arr[node]);
	}
}
