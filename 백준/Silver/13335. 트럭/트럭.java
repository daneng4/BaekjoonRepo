
import java.io.*;
import java.util.*;


public class Main {
	
	public static Queue<Integer> truck;
	public static Queue<Integer> bridge;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		truck = new LinkedList<>();
		bridge = new LinkedList<>();
		int time = 0;
		int weight = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i< w; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			if(!truck.isEmpty()) {
				if(truck.peek() + weight <= l) {
					weight += truck.peek();
					bridge.add(truck.poll());
				}else {
					bridge.add(0);
				}
			}
			
		}
		
		System.out.println(time);
		
	}
}
