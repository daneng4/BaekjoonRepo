
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		boolean isAscending = true;
		boolean isDescending = true;
		
		for(int i = 1; i<8; i++) {
			int num = Integer.parseInt(str[i]);
			int ex = Integer.parseInt(str[i-1]);
			
			if(num - ex > 0) {
				isDescending = false;
			}else {
				isAscending = false;
			}
		}
		
		if(isAscending)
			System.out.println("ascending");
		else if(isDescending)
			System.out.println("descending");
		else
			System.out.println("mixed");
		
	}		
}