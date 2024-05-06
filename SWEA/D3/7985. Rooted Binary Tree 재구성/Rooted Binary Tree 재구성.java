import java.util.*;
import java.io.*;

public class Solution {
	static int depth;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int k = Integer.parseInt(br.readLine());
			depth = (int)Math.pow(2, k) - 1;
			int[] tree = new int[depth+1];
			int[] node = new int[depth];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<depth; i++) {
				node[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			solve(0, depth-1, 1, 0, tree, node);
			int n = 0;
			int i = 1;
			for(int level = 0; level < k; level++){
                n += (int)Math.pow(2, level);
                for(; i <= n; i++){
                    sb.append(tree[i]).append(" ");
                }
                sb.append("\n");
            }
			
			bw.write(String.format("#%d %s", t, sb.toString()));
		} // testcase
		bw.flush();
	}
	public static void solve(int left, int right, int tidx, int nidx, int[]tree, int[] node) {
		int root = (left + right) / 2;
		tree[tidx] = node[root];
		if(left == right)
			return;
		solve(left, root-1, tidx*2, root, tree, node);
        solve(root+1, right, tidx*2+1, root, tree, node);
	}
}