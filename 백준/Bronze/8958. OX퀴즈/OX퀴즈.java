
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i<=n; i++) {
			String[] str = br.readLine().split("");
			int sum = 0;
			int cur = 0;
			
			for(int j = 0; j<str.length; j++) {
				if(str[j].equals("O")) {
					cur++;
					sum += cur;
				}else {
					cur = 0;
				}
			}
			
			System.out.println(sum);
		}
		
		
		
	}		
}