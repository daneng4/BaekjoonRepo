
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int time = n/4;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<time; i++) {
			sb.append("long" + " ");
		}
		sb.append("int");
		
		System.out.println(sb.toString());
	}
}