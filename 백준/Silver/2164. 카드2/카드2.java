
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
		
		for(int i = 1; i<=n; i++) {
			queue.add(i);
		}
		
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());	
		}
			System.out.println(queue.poll());
	}
}
