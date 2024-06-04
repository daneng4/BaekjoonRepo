
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int j = n-1;
		for(int i = 0; i<n; i++) {
			// 공백
			for(int k = j; k > 0; k--) {
				sb.append(" ");
			}
			for(int l = 0; l<n-j; l++) {
				sb.append("*");
			}
			sb.append("\n");
			j--;
		}
		
		System.out.println(sb.toString());
	}
}