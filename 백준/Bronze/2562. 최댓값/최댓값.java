
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		String input = "";
		int result = 0;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			list.add(Integer.parseInt(input));
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
				result = i;
			}
		}
		System.out.println(max);
		System.out.println(result+1);
		
	}
}
