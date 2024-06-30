
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		// ascii a
		int start = 'a';
		int end = 'z';
		for(int i = start; i<= end; i++) {
			char c = (char)i;
			sb.append(String.format("%d ", str.indexOf(c)));
		}
		
		System.out.println(sb.toString());
	}
}