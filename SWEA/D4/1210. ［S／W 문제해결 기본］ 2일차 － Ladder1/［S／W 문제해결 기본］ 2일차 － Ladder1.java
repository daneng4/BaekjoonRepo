
import java.io.*;
import java.util.*;

class Solution {
	static int[][] map;
	static int answer;
	static int[][] deltas = { { 0, -1 }, { 0, 1 }, { -1, 0 } }; // 좌,우,상

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int testNum = Integer.parseInt(br.readLine());
			map = new int[100][100];

			int x = 0;
			int y = 99;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					if (i == 99 && map[i][j] == 2)
						x = j;
				}
			}

			int nx, ny;
			while (y != 0) {
				for (int i = 0; i < 3; i++) {
					nx = x + deltas[i][1];
					ny = y + deltas[i][0];
					if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[ny][nx] == 0)
						continue;
					x = nx;
					y = ny;
					map[ny][nx] = 0;
				}
			}

			bw.write(String.format("#%d %d\n", testNum, x));

		} // end of testcase
		bw.flush();
	}
}
