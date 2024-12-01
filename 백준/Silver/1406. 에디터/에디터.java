import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Character> list = new LinkedList<>();
		char[] carr = br.readLine().toCharArray();
		
		for(char c : carr) {
			list.add(c);
		}
		
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("L")) {
				if(iter.hasPrevious()) {
					iter.previous();
				}
			} else if(command.equals("D")) {
				if(iter.hasNext()) {
					iter.next();
				}
			} else if(command.equals("B")) {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				char added = st.nextToken().charAt(0);
				iter.add(added);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}