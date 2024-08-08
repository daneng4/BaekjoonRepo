
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			if(a == 0 && b == 0 && c == 0) {
				break;
			}
			
			List<Integer> list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);
			
			Collections.sort(list, Collections.reverseOrder());
			
			if(Math.pow(list.get(1), 2) + Math.pow(list.get(2), 2) == Math.pow(list.get(0),2))
				System.out.println("right");
			else
				System.out.println("wrong");
			
		}
		
	}
}