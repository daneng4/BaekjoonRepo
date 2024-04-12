import java.util.*;
import java.io.*;

public class Solution {
	static int n, maxCal;
	static boolean[] visit;
	static int answer;
	static ArrayList<food> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 재료의 수
			maxCal = Integer.parseInt(st.nextToken()); // 칼로리 제한
			
			list = new ArrayList<>();
			visit = new boolean[n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int fav = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				list.add(new food(fav, cal));
			}
			answer = 0;
			solve(0, 0, 0);
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
	public static void solve(int count, int curFav, int curCal) {
		// 제한 칼로리는 넘으면 안됨
		if(curCal > maxCal)
			return;
		if(count == n) {
			// 맛점수 갱신
			if(curCal <= maxCal)
				answer = Math.max(answer, curFav);
			return;
		}
		
		// 현재 조합 선택
		solve(count+1, curFav + list.get(count).fav, curCal + list.get(count).cal);
		// 현재 조합 선택x
		solve(count+1, curFav, curCal);
	}
}
class food{
	int fav;
	int cal;
	public food(int fav, int cal) {
		this.fav = fav;
		this.cal = cal;
	}
}
