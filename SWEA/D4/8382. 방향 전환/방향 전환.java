import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int sx = Integer.parseInt(st.nextToken()) + 100;
        	int sy = Integer.parseInt(st.nextToken()) + 100;
        	int ex = Integer.parseInt(st.nextToken()) + 100;
        	int ey = Integer.parseInt(st.nextToken()) + 100;
        	int x = Math.abs(sx - ex); int y = Math.abs(sy - ey); 
        	int answer = Math.abs(x - y) % 2 == 0 ? 2 * Math.max(x, y) : 2 * Math.max(x, y) - 1;
        	
        	bw.write(String.format("#%d %d\n", tc, answer));
        }// tc
        bw.flush();
    }
}
