
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numericIdx = 0;
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i<3; i++) {
			String str = br.readLine();
			if(isNumberic(str)) {
				numericIdx = i;
			}
			
			list.add(str);
		}
		
		int number = Integer.parseInt(list.get(numericIdx));
		int next = number + list.size() - numericIdx;
		
		if(next % 3 == 0 && next % 5 == 0) {
			System.out.println("FizzBuzz");
		}else if(next % 3 == 0 && next % 5 != 0) {
			System.out.println("Fizz");
		}else if(next % 3 != 0 && next % 5 == 0) {
			System.out.println("Buzz");
		}else {
			System.out.println(next);
		}
		
	}
	public static boolean isNumberic(String str) {
		return str.chars().allMatch(Character::isDigit);
	}

}