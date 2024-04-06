
import java.util.*;
import java.io.*;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visit;
	static int n, m;
	// 방향 벡터
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	// 테트로미노의 모양이나 회전은 생각 안해도 되는 문제
	// dfs로 탐색하면서 아직 visit 하지 않은 곳을 탐색해나가면
	// 문제에서 주어진 테트로미노 모양으로 탐색이 가능해짐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = true;
				solve(i, j, map[i][j], 1);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
	}

	public static void solve(int r, int c, int sum, int count) {
		// 테트로미노 완성시 최대 점수 갱신
		if (count == 4) {
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int cr = r + dx[i];
			int cc = c + dy[i];

			// map 벗어날 시 continue
			if (cr < 0 || cc < 0 || cr >= n || cc >= m) {
				continue;
			}

			// 아직 미 방문이라면
			if (!visit[cr][cc]) {
				// 3번째 폴리오미노를 놓을 차례라면
				// ㅗ 모양을 위해서
				if (count == 2) {
					visit[cr][cc] = true;
					solve(r, c, sum + map[cr][cc], count + 1);
					visit[cr][cc] = false;
				}
				visit[cr][cc] = true;
				solve(cr, cc, sum + map[cr][cc], count + 1);
				visit[cr][cc] = false;
			}	
		}
	}
}