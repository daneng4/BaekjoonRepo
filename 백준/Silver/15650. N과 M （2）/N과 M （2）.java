
import java.io.*;
import java.util.*;

public class Main {

	private static int[] arr;
	public static int n,m;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		dfs(1, 0);
		
	}
	private static void dfs(int at, int depth) {
		if(depth == m) {
			for(int value : arr) {
				System.out.print(value + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = at; i<=n; i++) {
			arr[depth] = i;
			dfs(i+1, depth+1);
		}
	}
	
}
