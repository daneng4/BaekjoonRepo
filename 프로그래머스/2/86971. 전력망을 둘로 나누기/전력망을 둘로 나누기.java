import java.util.*;

class Solution {
    static List<Integer>[] list;
	static int min;
    public int solution(int n, int[][] wires) {
        int answer = -1;
		min = Integer.MAX_VALUE;
		list = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0; i<wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			boolean[] visit = new boolean[n+1];
			
			list[a].remove(Integer.valueOf(b));
			list[b].remove(Integer.valueOf(a));
			
			int count = dfs(1, visit);
			int dif = Math.abs(count - (n - count));
			min = Math.min(dif, min);
			list[a].add(b);
			list[b].add(a);
			
		}
		answer = min;
		return answer;
    }
    public static int dfs(int v, boolean[] visit) {
		
		visit[v] = true;
		int count = 1;
		for(int next : list[v]) {
			if(!visit[next]) {
				count+= dfs(next, visit);
			}
		}
		
		return count;
	}
}