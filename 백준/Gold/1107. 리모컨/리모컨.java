
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
        int m = sc.nextInt();
		
		boolean[] crack = new boolean[10];
		for(int i = 0; i<m; i++) {
			int n = sc.nextInt();
			crack[n] = true;
		}
		int max = 999999;
		int result = Math.abs(target - 100);
		for(int i = 0; i<= max; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isCrack = false;
			for(int j = 0; j<len; j++) {
				if(crack[str.charAt(j) - '0']) {
					isCrack = true;
					break;
				}
			}
			if(!isCrack) {
				int min = Math.abs(target - i) + len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
