import java.util.*;
import java.io.*;

/*
 * 구해야하는 것 : n에서 k까지의 최단 시간
 * 움직일 수 있는 방법 : 현재 위치에서 -1, +1, *2
 * 만약 도착지점을 초과한 경우 뒤로 가야하며 이때는 -1 연산밖에 없음 앞으로가는 것은 +1, *2
 * +1, -1은 1초가 소요되나 *2는 0초가 소요된다.
*/
public class Main {
	static int max = 100000;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit = new boolean[max+1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Info> q = new LinkedList<>();
		
		q.offer(new Info(n, 0));
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			int pos = info.pos;
			int time = info.time;
			visit[pos] = true;
			
			if(pos == k) {
				min = Math.min(min, time);
			}
			
			if(pos*2 <= max && !visit[pos*2]) {
				q.offer(new Info(pos*2, time));
			}
			if(pos+1 <= max && !visit[pos+1]) {
				q.offer(new Info(pos+1, time+1));
			}
			if(pos-1 >= 0 && !visit[pos-1]) {
				q.offer(new Info(pos-1, time+1));
			}
			
		}
		
		System.out.println(min);
		
	}
	
}
class Info{
	int time; // 현재까지 걸린 시간
	int pos; // 현재 위치
	
	Info(int curPos, int curTime){
		this.time = curTime;
		this.pos = curPos;
	}
}
