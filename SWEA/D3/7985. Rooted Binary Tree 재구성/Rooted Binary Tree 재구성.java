
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int k = Integer.parseInt(br.readLine());
			int depth = (int)Math.pow(2, k)-1;
			int[] node = new int[depth];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<depth; i++) {
				node[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] tree = new int[depth+1];
			solve(0, depth-1, 1, node, tree);
			
			StringBuilder sb = new StringBuilder();
			int n = 0;
			int j = 1;
			for(int i = 0; i<k; i++) {
				n += (int)Math.pow(2, i);
				for(; j <= n; j++) {
					sb.append(tree[j]).append(" ");
				}
				sb.append("\n");
			}
			
			bw.write(String.format("#%d %s", t, sb.toString()));
		} // testcase
		bw.flush();
	}
	public static void solve(int left, int right, int tidx, int[] node, int[] tree) {
		int root = (left + right) / 2;
		tree[tidx] = node[root];
		if(left == right)
			return;
		solve(left, root-1, tidx * 2, node, tree);
		solve(root+1, right, tidx * 2 + 1, node, tree);
		
	}
}