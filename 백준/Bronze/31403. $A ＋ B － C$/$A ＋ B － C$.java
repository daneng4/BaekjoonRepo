
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int sum = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
		String str = a.concat(b);
		int sum2 = Integer.parseInt(str) - Integer.parseInt(c);
		
		System.out.println(sum);
		System.out.println(sum2);
		
	}		
}