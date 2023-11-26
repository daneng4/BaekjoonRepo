
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		
		int result = 0;
		int count = 0;
		
		for(int i = 1; i<m-1; i++) {
			if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
				count++;
				if(count == n) {
					count--;
					result++;
				}
				i++;
			}else {
				count = 0;
			}
		}
		System.out.println(result);
		
	}
}
