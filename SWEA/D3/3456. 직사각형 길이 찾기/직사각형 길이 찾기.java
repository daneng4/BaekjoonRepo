import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 어떤 수가 1개밖에 없는 경우 or 3개인 경우 '어떤 수'가 답이 된다.
			Map<Integer, Integer> map = new HashMap<>();
			map.put(a, map.getOrDefault(a, 0) + 1);
			map.put(b, map.getOrDefault(b, 0) + 1);
			map.put(c, map.getOrDefault(c, 0) + 1);

			
			Set<Integer> set = map.keySet();
			int answer = 0;
			for(int key : set) {
				if(map.get(key) == 1 || map.get(key) == 3) {
					answer = key;
					break;
				}
			}
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
	}
}