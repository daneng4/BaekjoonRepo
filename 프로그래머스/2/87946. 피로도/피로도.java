import java.util.*;

class Solution {
    static boolean[] visit;
	static int result = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visit = new boolean[dungeons.length];
		solve(k, dungeons, 0, 0);
		answer = result;
        
        return answer;
    }
    public static void solve(int k, int[][] dungeons, int depth, int count) {
		// 모든 던전을 탐험했다면 최대 탐험 횟수 갱신
		if(depth == dungeons.length) {
			result = Math.max(result, count);
			return;
		}
		
		for(int i = 0; i<dungeons.length; i++) {
			if(visit[i]) // 이미 방문했던 던전이면 패스
				continue;
			int req = dungeons[i][0];
			int consum = dungeons[i][1];
			// 현재 피로도가 요구 피로도 보다 낮은 경우 패스
			if(k < req) {
				visit[i] = true;
				solve(k, dungeons, depth+1, count);
				visit[i] = false;
			}else {
				// 요구 피로도 만족 시
				visit[i] = true;
				solve(k-consum, dungeons, depth+1, count+1);
				visit[i] = false;
			}
		}
	}
}