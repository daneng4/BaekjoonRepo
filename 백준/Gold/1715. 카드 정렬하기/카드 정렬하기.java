
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<n; i++) {
			 pq.add(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		if (n == 1) {
			System.out.println(0);
		}else {
			while(true) {
				int a = pq.poll();
				int b = pq.poll();
				int sum = a+b;
				result+=sum;
				if(!pq.isEmpty())
					pq.offer(sum);
				else
					break;
			}
			System.out.println(result);
		}

	}
}
