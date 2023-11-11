
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		long sum = 0;
		int i = 1;
		int count = 0;
		while(sum <= num) {
			sum = sum + i;
			i++;
			count++;
		}
		count = count - 1;
		System.out.println(count);
	}
}
