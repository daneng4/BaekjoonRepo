
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<s.length; i++) {
			String us = s[i].toUpperCase();
			map.put(us, map.getOrDefault(us, 0) + 1);
		}
		
		List<String> keyset = new ArrayList<>(map.keySet());
		keyset.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
		
		if(map.size() == 1) {
			System.out.println(keyset.get(0));
			return;
		}
		
		int o = map.get(keyset.get(0));
		int t = map.get(keyset.get(1));
		if(o == t)
			System.out.println("?");
		else
			System.out.println(keyset.get(0));
			
	}
}