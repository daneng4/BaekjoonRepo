
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	Map<Character, Integer> map = new TreeMap<>();
    	
    	for(int i = 0; i<str.length(); i++) {
    		char s = str.charAt(i);
    		map.put(s, map.getOrDefault(s, 0) + 1);
    	}
    	
    	int odd = 0; // 홀수
    	
    	for(Character c : map.keySet()) {
    		// 홀수 개수면
    		if(map.get(c) % 2 == 1) {
    			odd += 1;
    		}
    	}
    	
    	// 문장 길이가 짝수면 원소 개수가 홀수 개수인 원소는 없어야함
    	if(str.length() % 2 == 0) {
    		if(odd > 0) {
    			System.out.println("I'm Sorry Hansoo");
    			return;
    		}
    	} // 길이가 홀수면 원소 개수가 홀수 개수인 원소는 1개여야함
    	else {
    		if(odd > 1) {
    			System.out.println("I'm Sorry Hansoo");
    			return;
    		}
    	}
    	
    	StringBuilder front = new StringBuilder();
    	StringBuilder back = new StringBuilder();
    	char oddElement = 0;
    	
    	for(Character c : map.keySet()) {
    		if(map.get(c) % 2 == 1) {
    			oddElement = c;
    		}
    		
			for(int i = 0; i<map.get(c)/2; i++) {
    			front.append(c);
    		}
    		for(int i = 0; i<map.get(c)/2; i++) {
    			back.append(c);
    		}
    	}
    	
    	if(str.length() % 2 == 1) {
    		front.append(oddElement);
    	}
    	front.append(back.reverse());
    	
    	System.out.println(front.toString());
	}
}