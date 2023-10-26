import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n % 2 == 1) { // 홀수면 상근이 win
			System.out.println("SK");
		}else { // 짝수면 창영이 win
			System.out.println("CY");
		}
		
	}
}
