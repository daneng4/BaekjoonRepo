import java.io.*;
import java.util.*;

public class Main {
	private static Map<Character, Integer> map;
	private static int answer = 0;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String dna = br.readLine();
		
		map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		map.put('A', Integer.parseInt(st.nextToken()));
		map.put('C', Integer.parseInt(st.nextToken()));
		map.put('G', Integer.parseInt(st.nextToken()));
		map.put('T', Integer.parseInt(st.nextToken()));
		
		int start = 0; int end = P-1;
		while(true) {
			
			if(start == 0) {
				for(int i = start; i<=end; i++) {
					checkPassword(dna.charAt(i));
				}
				checkPossible();
			}else {
				checkPossible();
			}
			char startC = dna.charAt(start);
			map.put(startC, map.get(startC) + 1);
			start += 1;
			end += 1;
			if(end == S)
				break;
			char endC = dna.charAt(end);
			map.put(endC, map.get(endC) - 1);
			
		}
		
		System.out.println(answer);
	}
	private static void checkPassword(char c) {
		switch (c) {
			case 'A' : {
				map.put(c, map.get(c) - 1);
				break;
			}
			
			case 'C' : {
				map.put(c, map.get(c) - 1);
				break;
			}
			
			case 'G' : {
				map.put(c, map.get(c) - 1);
				break;
			}
			
			case 'T' : {
				map.put(c, map.get(c) - 1);
				break;
			}
		}
	}
	private static void checkPossible() {
		for(char key : map.keySet()) {
			if(map.get(key) > 0) {
				return;
			}
		}
		
		answer +=1;
		return;
	}
}