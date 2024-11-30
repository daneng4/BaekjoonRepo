import java.util.*;
import java.io.*;

public class Main {
	static LinkedList<Integer> q;
	static Queue<Integer> p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 큐의 크기
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수
		q = new LinkedList<>();
		p = new LinkedList<>();
		
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			p.add(Integer.parseInt(st.nextToken()));
		}
		
		int queueStart = 0;
		int answer = 0;
		while(!p.isEmpty()) {
			int target = p.poll();
			int queueEnd = q.size()-1;
			int pos = findPos(target);
			
			int firstDiff = Math.abs(pos - queueStart); // 처음부터 타겟까지 거리
			int lastDiff = Math.abs(pos - queueEnd)+1; // 마지막부터 타겟까지 거리
			
			// 타겟이 앞쪽에 가까우면
			if(firstDiff < lastDiff) {
				while(q.peekFirst() != target) {
					q.addLast(q.pollFirst());
					answer+=1;
				}
				q.pollFirst();
			}
			// 타겟이 뒤쪽에 가까우면
			else {
				while(q.peekFirst() != target) {
					q.addFirst(q.pollLast());
					answer+=1;
				}
				q.pollFirst();
			}
		}
		
		System.out.println(answer);
	}
	static int findPos(int number) {
		return q.indexOf(number);
	}
}