import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		sb.append(st.nextToken());
		
		String reverse = sb.reverse().toString();
		int n1 = Integer.parseInt(reverse);
		
		sb = new StringBuilder();
		sb.append(st.nextToken());
		
		reverse = sb.reverse().toString();
		int n2 = Integer.parseInt(reverse);
		
		System.out.println(n1 > n2 ? n1 : n2);
	}
}
