import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i<=n; i++) {
			String number = String.valueOf(i);
			
			clap(number);
		}
		
		System.out.println(sb.toString());
    }
	static void clap(String number) {
		boolean samyookgoo = false;
		for(int i = 0; i<number.length(); i++) {
			int num = number.charAt(i) -'0';
			if(num == 3 || num == 6 || num == 9) {
				samyookgoo = true;
				sb.append("-");
			}
		}
		if(samyookgoo) {
			sb.append(" ");
			return;
		}
		sb.append(number + " ");
	}
}
