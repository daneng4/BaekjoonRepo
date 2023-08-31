import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int [] apart = new int[25*25];
	static int[] dx = {1,-1,0,0}; // x좌표 이동을 위한 배열
	static int[] dy = {0,0,1,-1}; // y좌표 이동을 위한 배열
	static int n = 0;
	static int num = 0; // 단지 번호
    public static void main(String[] args) throws IOException {
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       n = Integer.parseInt(br.readLine());
       
       map = new int[n][n];
       visited = new boolean[n][n];
       
       for(int i = 0; i<n; i++) {
    	   String data = br.readLine();
    	   for(int j = 0; j<n; j++) {
    		   char[] cdata = data.toCharArray();
    		   map[i][j] = cdata[j] -'0'; 
    	   }
       }
       
       for(int i = 0; i<n; i++) {
    	   for(int j = 0; j<n; j++) {
    		   if (map[i][j] == 1 && !visited[i][j]) { // 1이고 아직 방문안했다면
    			   num++; // 아파트 단지번호 + 1
    			   dfs(i,j);
    		   }
    	   }
       }
       Arrays.sort(apart);
       System.out.println(num);

       for(int i=0; i<apart.length; i++){
           if(apart[i] == 0){
           }else{               
               System.out.println(apart[i]);
           }
       }
   }

    
    public static void dfs(int x, int y) {
    	int nowX = x;
    	int nowY = y;
    	visited[nowX][nowY] = true;
    	apart[num]++; // 단지들개수 + 1
    	
    	for(int k = 0; k<4; k++) {
    		int nextX = nowX + dx[k];
    		int nextY = nowY + dy[k];
    		// 다음좌표가 맵을 벗어나지 않고
    		if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) { 	
	    		// 다음좌표가 아직 방문을 안하고 1일때
	    		if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
	    			dfs(nextX, nextY);
	    		}		
    		}
    	}
    }
}
