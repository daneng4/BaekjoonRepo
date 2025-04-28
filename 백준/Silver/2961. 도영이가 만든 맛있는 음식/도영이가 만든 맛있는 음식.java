import java.util.*;
import java.io.*;

class Main {
    static int n, answer;
    static int[][] taste;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        taste = new int[n][2];
        isSelected = new boolean[n];
        
        for(int i = 0; i<n; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int sin = Integer.parseInt(st.nextToken());
            int ssn = Integer.parseInt(st.nextToken());
            taste[i][0] = sin;
            taste[i][1] = ssn;
        }
        
        answer = Integer.MAX_VALUE;
        run(0);
        System.out.println(answer);
    }
    public static void run(int count) {
    	if(count == n) {
    		answer = Math.min(answer, getTaste());
    		return;		
    	}
    	
        isSelected[count] = true;
        run(count+1);

        isSelected[count] = false;
        run(count+1);
    }
    public static int getTaste() {
    	int sin = 1;
    	int ssn = 0;
    	for(int i=0; i<n; i++) {
            if(isSelected[i]) {
                sin *= taste[i][0];
                ssn += taste[i][1];
            }
        }
    	
    	// 아무것도 고르지 않았을 때
    	if(ssn == 0 && sin == 1) 
    		return Integer.MAX_VALUE;
    	
    	return Math.abs(ssn - sin);
    }
}