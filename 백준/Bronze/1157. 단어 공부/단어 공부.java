import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str = str.toLowerCase();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int max = 0;
		for(Character s : map.keySet()) {
			int value = map.get(s);
			max = Math.max(value, max);
		}
		
		int count = 0;
		String maxAlpha = "";
		for(Character s : map.keySet()) {
			if(max == map.get(s)) {
				if(count != 0) {
					System.out.println("?");
					return;
				}
				
				count++;
				maxAlpha = String.valueOf(s);
			}
		}
		
		System.out.println(maxAlpha.toUpperCase());
	}

}
