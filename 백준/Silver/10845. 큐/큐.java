
import java.util.*;
import java.io.*;

public class Main {
	static final String PUSH = "push";
	static final String POP = "pop";
	static final String SIZE = "size";
	static final String EMPTY = "empty";
	static final String FRONT = "front";
	static final String BACK = "back";
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			
			if(command[0].equals(PUSH)) {
				int number = Integer.parseInt(command[1]);
				q.add(number);
			}else if(command[0].equals(POP)) {
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.pollFirst());
			}else if(command[0].equals(SIZE)) {
				System.out.println(q.size());
			}else if(command[0].equals(EMPTY)) {
				if(q.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}else if(command[0].equals(FRONT)) {
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.peekFirst());
			}else {
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.peekLast());
			}
			
		}
		
	}
}