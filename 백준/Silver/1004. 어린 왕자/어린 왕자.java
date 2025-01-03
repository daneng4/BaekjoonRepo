
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int testcase = Integer.parseInt(br.readLine());
    	for(int i = 0; i<testcase; i++) {		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		int n = Integer.parseInt(br.readLine());
    		int startContains = 0;
    		int endContains = 0;
    		
    		for(int j = 0; j<n; j++) {
    			st = new StringTokenizer(br.readLine());
    			int cx = Integer.parseInt(st.nextToken());
    			int cy = Integer.parseInt(st.nextToken());
    			int r = Integer.parseInt(st.nextToken());
    			
    			if(isInSameCircle(x1,y1,x2,y2,cx,cy,r))
    				continue;
    			startContains += hasContain(x1, y1, cx, cy, r);
        		endContains += hasContain(x2, y2, cx, cy, r);
    		}
    		
    		System.out.println(startContains + endContains);
    	}
    }
    public static int hasContain(int x, int y, int cx, int cy, int r) {
    	int len = (int)(Math.pow(x-cx, 2) + Math.pow(y-cy, 2));
    	if(len <= Math.pow(r, 2)) {
    		return 1;
    	}
    	return 0;
    }
    public static boolean isInSameCircle(int x1, int y1, int x2, int y2, int cx, int cy, int r) {
    	int lenWithStart = (int)(Math.pow(x1-cx, 2) + Math.pow(y1-cy, 2));
    	int lenWithEnd = (int)(Math.pow(x2-cx, 2) + Math.pow(y2-cy, 2));
    	
    	if(lenWithStart <= Math.pow(r, 2) && lenWithEnd <= Math.pow(r, 2)) {
    		return true;
    	}
    	return false;
    }
}