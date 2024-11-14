import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Queue<Seq> q;
		
		for(int t = 0; t<T; t++) {
			q = new LinkedList<>();
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int[] maxValue = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				int ele = Integer.parseInt(st.nextToken());
				maxValue[i] = ele;
				if(i == target)
					q.add(new Seq(ele, true));
				else
					q.add(new Seq(ele, false));
			}
			
			Arrays.sort(maxValue);
			int idx = maxValue.length-1;
			
			while(!q.isEmpty()) {
				Seq poll = q.poll();
				// target이 오면
				if(poll.target && poll.num == maxValue[idx]) {
					answer += 1;
					break;
				}else if(poll.num == maxValue[idx]) {
					idx--;
					answer++;
				}else {
					q.add(poll);
				}
				
			}
			
			System.out.println(answer);
		}
	}
}
class Seq{
	int num;
	boolean target;
	public Seq(int num, boolean target) {
		this.num = num;
		this.target = target;
	}
}