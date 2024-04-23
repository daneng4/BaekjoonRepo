
import java.io.*;
import java.util.*;

class Solution {
	static ArrayList<Integer> ylist;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			ylist = new ArrayList<>();
			
			int addict = 1;
			int value = 1;
			
			// y좌표를 1부터 시작하기 위함
			ylist.add(0);
			// x=1로 고정, y좌표값들이 저장됨
			while(ylist.size() <= 282) {
				ylist.add(value);
				value += addict++;
			}
			
			int ppoint = 0;
			int qpoint = 0;
			// p 와 q는 (1,i), (i,1) 사이에 있다는 것을 알 수 있음
			for(int i = 1; i<=ylist.size(); i++) {
				if(ylist.get(i) > p) {
					ppoint = i-1;
					break;
				}else if(ylist.get(i) == p){
					ppoint = i;
					break;
				}
			}
			for(int i = 1; i<=ylist.size(); i++) {
				if(ylist.get(i) > q) {
					qpoint = i-1;
					break;
				}else if(ylist.get(i) == q) {
					qpoint = i;
					break;
				}
			}
			
			// p,q값과 ylist 값의 차이만큼 x를 더해주고 y를 빼주면
			// p,q값을 가지는 좌표를 구할 수 있음
			int sub = p - ylist.get(ppoint);
			int px = 1+sub; int py = ppoint - sub;
			sub = q - ylist.get(qpoint);
			int qx = 1+sub; int qy = qpoint - sub;
			
			int ax = px+qx; int ay = py+qy;
			
			// (ax,ay) 좌표의 값을 구해야함
			// (1,ay)=ylist.get(ay) 에서 좌측으로 ax까지 움직여야함
			// 이때 좌측으로 1칸움직일때마다 값은 (1,ay) + (ay+(addict++)) 이 된다. 
			int answer = ylist.get(ay);
			addict = 1;

			for(int i = 1; i<ax; i++) {
				answer = answer + ay + (addict++);
			}
			
			bw.write(String.format("#%d %d\n", test_case, answer));
		} // end of testcase
		bw.flush();
	}
}
