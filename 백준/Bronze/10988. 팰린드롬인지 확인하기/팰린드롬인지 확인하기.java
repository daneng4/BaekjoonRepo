
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		boolean ok = true;
		
		for(int i = 0; i<word.length()/2; i++) {
			int front = word.charAt(0 + i);
			int rear = word.charAt(word.length() - 1 - i);
			if(front == rear)
				continue;
			else {
				ok = false;
				break;
			}
		}
	
		if(ok)
			System.out.println(1);
		else
			System.out.println(0);
	}
}