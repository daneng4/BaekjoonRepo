import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[][] map;
	static boolean[][] drown;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxRain = 0;
        
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		maxRain = Math.max(maxRain, map[i][j]);
        	}
        }
        
        int answer = 0;
        for(int i = 0; i<=maxRain; i++) {
        	visit = new boolean[N][N];
        	// 물에 잠기게하기
        	raining(i);
        	int area = 0;
        	
        	for(int j = 0; j<N; j++) {
        		for(int k = 0; k<N; k++) {
        			// 물에 잠겼거나 방문했던 곳은 bfs 탐색 시작 지점이 되어선 안됨
        			if(drown[j][k] || visit[j][k])
        				continue;
        			
        			// 안전한 영역 찾기
        			findSafeArea(j,k);
        			area++;
        		}
        	}
        	
        	answer = Math.max(answer, area);
        }
        
        System.out.println(answer);
    }
    
    public static void raining(int rain) {
    	drown = new boolean[N][N];
    	
    	for(int i = 0; i<N; i++) {
    		for(int j = 0; j<N; j++) {
    			if(map[i][j] <= rain) {
    				drown[i][j] = true;
    			}
    		}
    	}
    }
    
    // BFS
    public static void findSafeArea(int x, int y) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {x,y});
    	visit[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		
    		for(int i = 0; i<4; i++) {
    			int nx = cur[0] + dx[i];
    			int ny = cur[1] + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])
    				continue;
    			
    			if(drown[nx][ny])
    				continue;
    			
    			q.add(new int[] {nx,ny});
    			visit[nx][ny] = true;
    		}
    	}
    	
    }
}