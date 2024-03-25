import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc<testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] num = new String[n];
			for(int i = 0; i<n; i++) {
				num[i] = br.readLine();
			}
			
			Arrays.sort(num);
			
			if(check(num)) {
				sb.append("NO").append("\n");
			}
			else
				sb.append("YES").append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
	public static boolean check(String[] num) {
		for(int i = 0; i<num.length-1; i++) {
			if(num[i+1].startsWith(num[i]))
				return true;
		}
		return false;
	}
}