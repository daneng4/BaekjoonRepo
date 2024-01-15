
import java.io.*;
import java.util.*;
class Main {
	static int[] answer;
	static int[] pick;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = new int[10];
		pick = new int[10];
		for(int i = 0; i<10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0);
		System.out.println(result);
	}
	public static void solve(int depth) {
		// 10문제에 도달했으면 정답 체크
		if(depth == 10) {
			int count = 0;
			for(int i = 0; i<10; i++) {
				if(pick[i] == answer[i])
					count++;
			}
			if(count >= 5)
				result++;
			return;
		}
		
		for(int i = 1; i<=5; i++) {
			// 3문제 이상 풀은 경우
			if(depth >= 2) {
				// 전, 전전 문제와 답이 같다면 패스
				if(pick[depth-2] == i && pick[depth-1] == i) {
					continue;
				}
			}
			pick[depth] = i;
			solve(depth+1);
		}
	}
}
