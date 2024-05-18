import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=n; i++)
			q.add(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// 큐에 원소가 하나만 남을때까지 반복한다
		while(q.size() != 1) {
			int count = 1;
			
			// count가 k가 될 때까지 반복
			while(count != k) {
				q.add(q.poll());
				count++;
			}
			
			sb.append(q.poll() + ", ");
		}
		
		// 맨 마지막 원소를 sb에 추가, 문장 완성
		sb.append(q.poll() + ">");
		System.out.println(sb.toString());
	}
}