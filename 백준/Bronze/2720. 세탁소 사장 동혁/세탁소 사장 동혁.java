
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(num / 25 + " ");
			num = num % 25;
			sb.append(num / 10 + " ");
			num = num % 10;
			sb.append(num / 5 + " ");
			num = num % 5;
			sb.append(num + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
}