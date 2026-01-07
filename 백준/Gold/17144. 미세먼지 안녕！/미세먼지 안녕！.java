import java.util.*;
import java.io.*;

class Main {
	static int R,C,T;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] ac1; // 위 공기청정기
	static int[] ac2; // 아래 공기 청정기
	static int[][] map;
	static int[][] movedDust;
	static Queue<int[]> dusts;
	static BufferedReader br;
	static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        dusts = new ArrayDeque<>();
        int count = 0;
        
        for(int i = 0; i<R; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j<C; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		
        		// 미세먼지 위치 파악
        		if (map[i][j] > 0) {
        			dusts.add(new int[] {i, j});
        			continue;
        		}
        		
        		// 공기 청정기 위치 파악
        		if(map[i][j] == -1) {
        			if(count == 1) {
        				ac2 = new int[] {i,j};
        			}else {
        				ac1 = new int[] {i,j};
        				count++;
        			}
        		}
        		
        	}
        }
        
        while(T --> 0) {
        	// 미세먼지 별 확산될 양 구하기
        	getMovedDust();
        	
        	// 미세먼지 확산
        	moveDust();
        	
        	// 공기청정기 가동
        	acActivate();
        }
        
        int answer = 0;
        for(int i = 0; i<R; i++) {
        	for(int j = 0; j<C; j++) {
        		if(map[i][j] > 0)
        			answer += map[i][j];
        	}
        }
        
        System.out.println(answer);
    }
    
    public static void getMovedDust() {
    	movedDust = new int[R][C];
    	
    	for(int i = 0; i<R; i++) {
    		for(int j = 0; j<C; j++) {
    			if(map[i][j] > 0) {
    				movedDust[i][j] = map[i][j] / 5;
    			}
    		}
    	}
    }
    
    public static void moveDust() {
    	for(int i = 0; i<R; i++) {
    		for(int j = 0; j<C; j++) {
    			if(map[i][j] > 0) {
    				for(int k = 0; k<4; k++) {
    	    			int nx = i + dx[k];
    	    			int ny = j + dy[k];
    	    			
    	    			if(nx < 0 || ny < 0 || nx >= R || ny >= C)
    	    				continue;
    	    			
    	    			if(map[nx][ny] == -1)
    	    				continue;
    	    			
    	    			// movedDust[i][j] = map[i][j] / 5
    	    			map[nx][ny] += movedDust[i][j];
    	    			map[i][j] -= movedDust[i][j];
    	    		}
    			}
    		}
    	}
    }
    
    public static void acActivate() {
    	// 위 공기청정기 가동
    	ac1Activate();
    	
    	// 아래 공기청정기 가동
    	ac2Activate();
    }
    
    public static void ac1Activate() {
    	// 위 공기청정기인데 왼쪽 면
    	int upR = ac1[0];
    	
    	
    	for(int i = upR - 1; i > 0; i--) map[i][0] = map[i-1][0];
    	// 윗면
    	for(int i = 0; i < C - 1; i++) map[0][i] = map[0][i+1];
    	// 오른쪽
    	for(int i = 0; i < upR; i++) map[i][C-1] = map[i+1][C-1];
    	// 아래
    	for(int i = C-1; i > 1; i--) map[upR][i] = map[upR][i-1];
    	map[upR][1] = 0;
    }
    
    public static void ac2Activate() {
    	int downR = ac2[0];
    	// 왼쪽
    	for(int i = downR + 1; i< R-1; i++) map[i][0] = map[i+1][0];
    	// 아래
    	for(int i = 0; i<C-1; i++) map[R-1][i] = map[R-1][i+1];
    	// 오른쪽
    	for(int i = R-1; i>downR; i--) map[i][C-1] = map[i-1][C-1];
    	// 윗면
    	for(int i = C-1; i > 1; i--) map[downR][i] = map[downR][i-1];
    	map[downR][1] = 0;
    }
    
}