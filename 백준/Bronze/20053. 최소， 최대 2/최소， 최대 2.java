
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(num, max);
				min = Math.min(min, num);
			}
			sb.append(min + " ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
