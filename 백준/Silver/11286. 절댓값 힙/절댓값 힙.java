import java.io.*;
import java.util.*;

public class Main {
	static class Heap implements Comparable<Heap> {
		int x;
		public Heap(int x){
			this.x = x;
		}
		public int compareTo(Heap h){
			if(Math.abs(this.x) == Math.abs(h.x)){
				return this.x - h.x;
			}
			return Math.abs(this.x) - Math.abs(h.x);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Heap> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());

		while(n -- > 0){
			int num = Integer.parseInt(br.readLine());

			if(num == 0){
				if(pq.isEmpty())
					sb.append("0\n");
				else
					sb.append(pq.poll().x + "\n");
			}else{
				pq.add(new Heap(num));
			}
		}

		System.out.println(sb);
	}
}
