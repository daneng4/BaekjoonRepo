import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		while(n -- > 0){
			int num = Integer.parseInt(br.readLine());
			if(num == 0){
				if(pq.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			}else{
				pq.add(num);
			}
		}

		System.out.println(sb);
	}
}
