
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] R = new int[n+1];
			int[] W = new int[m+1];
			
			// 단위 무게당 요금 R
			for(int i = 1; i<=n; i++) {
				R[i] = Integer.parseInt(br.readLine());
			}
			
			// 차량의 무게 W
			for(int i = 1; i<=m; i++) {
				W[i] = Integer.parseInt(br.readLine());
			}
			
			Queue<Integer> q = new LinkedList<>();
			// 들어오는 차량의 수의 2배만큼 입력을 받음, 들어오면 반드시 나가게 되어있기 때문에
			for(int i = 0; i<m*2; i++) {
				int info = Integer.parseInt(br.readLine());
				q.add(info);
			}
			int[] park = new int[n+1];
			int[] info = new int[m+1];
			int sum = 0;
			Queue<Integer> wait = new LinkedList<>();
			
			while(!q.isEmpty()) {
				int car = q.poll();
				
				// 차량이 들어왔다면
				if(car > 0) {
					// 주차 자리 탐색
					int parkArea = findPark(park);
					// 주차 자리가 있다면
					if(parkArea > 0) {
						park[parkArea] += 1;
						sum += W[car] * R[parkArea];
						info[car] = parkArea;
					} 
					// 자리가 없다면
					else {
						wait.add(car);
					}
				}
				// 차량이 나간다면
				else {
					int parkedArea = info[Math.abs(car)];
					park[parkedArea] -= 1;
					
					// 기다리는 차가 있다면
					if(wait.size() >= 1) {
						int waiter = wait.poll();
						// 방금 나간 차 자리에 주차
						info[waiter] = parkedArea;
						park[parkedArea] += 1;
						sum += W[waiter] * R[parkedArea];
					}
				}
				
			}
			bw.write(String.format("#%d %d\n", t, sum));
		} // end of test case
		bw.flush();
	}
	public static int findPark(int[] park) {
		for(int i = 1; i<=park.length-1; i++) {
			if(park[i] == 0)
				return i;
		}
		return -1;
	}
}