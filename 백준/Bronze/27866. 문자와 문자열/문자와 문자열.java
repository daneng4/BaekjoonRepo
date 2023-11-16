
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(str[n-1]);
	}
}
