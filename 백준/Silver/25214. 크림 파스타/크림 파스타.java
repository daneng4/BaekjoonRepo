import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		int ans = 0;

		for(int i = 0; i<n; i++){
			int num = Integer.parseInt(st.nextToken());
			if(min > num)
				min = num;
			else
				ans = Math.max(ans, num-min);
			sb.append(ans).append(" ");
		}

		System.out.println(sb);
	}
}
