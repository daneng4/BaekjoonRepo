import java.io.*;
import java.util.*;

public class Main {
	private static Queue<Integer> bridge;
	private static Queue<Integer> ends;
	private static int l;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 건널 트럭 개수
		int w = Integer.parseInt(st.nextToken()); // 동시에 건널 수 있는 트럭 수
		l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		Queue<Integer> trucks = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		bridge = new LinkedList<>(); // 다리
		ends = new LinkedList<>(); // 건넌 트럭 담을 큐
		for(int i = 0; i<w; i++) {
			bridge.add(0);
		}
		
		int time = 0;
		// 트럭이 전부 건너기 전까지 반복하여 수행
		while(ends.size() != n) {
			time += 1;
			int end = bridge.poll();
			if(end > 0) {
				ends.add(end);
			}
			if(checkWeight(bridge, trucks.peek())) {
				bridge.add(trucks.poll());
				trucks.add(0);
			}else {
				bridge.add(0);
			}
		}
		
		System.out.println(time);
	}
	private static boolean checkWeight(Queue<Integer> bridge, int truck) {
		int weight = 0;
		for(int w : bridge) {
			weight += w;
		}
		
		if(weight + truck > l)
			return false;
		return true;
	}
}