import java.util.*;
import java.io.*;

class Main {
	static char[][] map;
	static int h, w;
	static Set<Character> keys;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answer;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	while(T-- > 0) {
    		answer = 0;
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		h = Integer.parseInt(st.nextToken());
    		w = Integer.parseInt(st.nextToken());
    		
    		map = new char[h+2][w+2];
    		
    		for(int i = 1; i<=h; i++) {
    			String str = br.readLine();
    			for(int j = 1; j<=w; j++) {
    				char c = str.charAt(j-1);
    				if(c == '.') continue;
    				
    				map[i][j] = c;
    			}
    		}
    		
    		keys = new HashSet<>();
    		String key = br.readLine();
    		if(!key.equals("0")) {
    			for(int i = 0; i<key.length(); i++) {
        			keys.add(key.charAt(i));
        		}
    		}
    		
    		// 탐색
    		bfs(0, 0);
    		
    		System.out.println(answer);
    	}
    	
    }
    public static void bfs(int x, int y) {
    	boolean[][] visit = new boolean[h+2][w+2];
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	Queue<int[]>[] q2 = new Queue[26];
    	
    	for(int i = 0; i<26; i++) {
    		q2[i] = new ArrayDeque<>();
    	}
    	
    	q.add(new int[] {x, y});
    	visit[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cx = cur[0];
    		int cy = cur[1];
    		
    		for(int i = 0; i<4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx > h+1 || ny > w+1) continue;
        		
        		if(map[nx][ny] == '*' || visit[nx][ny]) continue;
        		
        		visit[nx][ny] = true;
        		if(Character.isUpperCase(map[nx][ny])) {		
        			// 키로 열수있는지
        			if(keys.contains(Character.toLowerCase(map[nx][ny]))) {
        				q.add(new int[] {nx, ny});
        			}else {
        				q2[map[nx][ny] - 'A'].add(new int[] {nx, ny});
        				continue;
        			}
        		}
        		
        		if(Character.isLowerCase(map[nx][ny])) {
        			keys.add(map[nx][ny]);
        			
        			while(!q2[map[nx][ny] - 'a'].isEmpty()) {
        				q.add(q2[map[nx][ny] - 'a'].poll());
        			}
        			
        			map[nx][ny] = '.';
        		}
        		
        		if(map[nx][ny] == '$') {
        			answer++;
        			map[nx][ny] = '.';
        		}
        		
        		q.add(new int[] {nx, ny});
    		}
    	}
    }
}