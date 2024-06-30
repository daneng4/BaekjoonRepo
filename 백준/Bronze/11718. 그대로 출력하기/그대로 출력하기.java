import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if(input == null || input.isEmpty()) {
				break;
			}
			sb.append(input);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}