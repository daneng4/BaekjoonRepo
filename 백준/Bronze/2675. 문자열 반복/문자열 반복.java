import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int j = 0; j<str.length(); j++) {
				for(int i = 0; i<R; i++) {
					sb.append(str.charAt(j));
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}