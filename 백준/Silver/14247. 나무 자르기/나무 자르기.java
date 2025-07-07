import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tree = new int[n];

		long answer = 0;
		for(int i = 0; i<n; i++){
			tree[i] = Integer.parseInt(st.nextToken());
			answer += tree[i];
		}

		int[] grow = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			grow[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(grow);
		for(int i = 0; i<n; i++){
			answer += (long)grow[i] * i;
		}

		System.out.println(answer);
	}
}
