
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
 
public class Solution {
	static int n, m;
	static String[][] map;
	static int startx, starty;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int testCase = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=testCase; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new String[n][m];
            
            startx = 0; starty = 0;
            for(int i = 0; i<n; i++) {
            	String[] str = br.readLine().split("");
            	for(int j = 0; j<m; j++) {
            		map[i][j] = str[j];
            		if(map[i][j].equals("<") || map[i][j].equals("^") || map[i][j].equals(">") || map[i][j].equals("v")) {
            			startx = i;
            			starty = j;
            		}
            	}
            }
            
            int k = Integer.parseInt(br.readLine());
            String[] commands = br.readLine().split("");
            
            for(int i = 0; i<k; i++) {
            	game(startx, starty, commands[i]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");
            
            for(int i = 0; i<n; i++) {
            	for(int j = 0; j<m; j++) {
            		sb.append(map[i][j]);
            	}
            	sb.append("\n");
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }
    public static void game(int x, int y, String command) {
    	// 포탄 발사라면
    	if(command.equals("S")) {
    		// 보는 방향으로 포탄을 발사해야함
    		shoot(x,y);
    	}
    	// 움직이는 명령이라면
    	else if(command.equals("U")) {
    		map[x][y] = "^";
    		int nextx = x-1;
    		if(nextx >= 0 && map[nextx][y].equals(".")) {
    			map[nextx][y] = map[x][y];
    			map[x][y] = ".";
    			startx = nextx; starty = y;
    		}
    		
    	}
    	else if(command.equals("D")) {
    		map[x][y] = "v";
    		int nextx = x+1;
    		if(nextx <= n-1 && map[nextx][y].equals(".")) {
    			map[nextx][y] = map[x][y];
    			map[x][y] = ".";
    			startx = nextx; starty = y;
    		}
    		
    	}
    	else if(command.equals("L")) {
    		map[x][y] = "<";
    		int nexty = y-1;
    		if(nexty >= 0 && map[x][nexty].equals(".")) {
    			map[x][nexty] = map[x][y];
    			map[x][y] = ".";
    			startx = x; starty = nexty;
    		}
    		
    	}
    	else if(command.equals("R")) {
    		map[x][y] = ">";
    		int nexty = y+1;
    		if(nexty <= m-1 && map[x][nexty].equals(".")) {
    			map[x][nexty] = map[x][y];
    			map[x][y] = ".";
    			startx = x; starty = nexty;
    		}
    		
    	}
    }
    public static void shoot(int x, int y) {
    	// 왼쪽을 보고 있었다면
    	if(map[x][y].equals("<")) {
    		// 포탄은 왼쪽으로 맵을 벗어날때까지 진행
    		while(y-1 >= 0) {
    			y--;
    			// 중간에 벽돌을 만났다면
    			if(map[x][y].equals("*")) {
    				map[x][y] = ".";
    				return;
    			} // 강철을 만났다면
    			else if(map[x][y].equals("#"))
    				return;
    		}
    	}
    	// 위쪽을 보고 있었다면
    	else if(map[x][y].equals("^")) {
    		// 포탄은 위로 맵을 벗어날때까지 진행
    		while(x-1 >= 0) {
    			x--;
    			// 중간에 벽돌을 만났다면
    			if(map[x][y].equals("*")) {
    				map[x][y] = ".";
    				return;
    			} // 강철을 만났다면
    			else if(map[x][y].equals("#"))
    				return;
    		}
    	}
    	// 오른쪽을 보고 있었다면
    	else if(map[x][y].equals(">")) {
    		// 포탄은 오른쪽으로 맵을 벗어날때까지 진행
    		while(y+1 <= m-1) {
    			y++;
    			// 중간에 벽돌을 만났다면
    			if(map[x][y].equals("*")) {
    				map[x][y] = ".";
    				return;
    			} // 강철을 만났다면
    			else if(map[x][y].equals("#"))
    				return;
    		}
    	}
    	// 아래를 보고 있었다면
    	else if(map[x][y].equals("v")) {
    		// 포탄은 아래로 맵을 벗어날때까지 진행
    		while(x+1 <= n-1) {
    			x++;
    			// 중간에 벽돌을 만났다면
    			if(map[x][y].equals("*")) {
    				map[x][y] = ".";
    				return;
    			} // 강철을 만났다면
    			else if(map[x][y].equals("#"))
    				return;
    		}
    	}
    }
}