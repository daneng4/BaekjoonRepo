
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, String> memo = new HashMap<>();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			memo.put(site, pw);
		}
		
		for(int i = 0; i<m; i++) {
			String find = br.readLine();
			sb.append(memo.get(find)).append("\n");
		}
		System.out.println(sb);
	}
}
