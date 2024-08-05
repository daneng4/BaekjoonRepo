
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int validNumber = 0;
		String[] numbers = br.readLine().split(" ");
		
		for(int i = 0; i<numbers.length; i++) {
			validNumber += Math.pow(Integer.parseInt(numbers[i]), 2);
		}
		
		System.out.println(validNumber % 10);
	}		
}