import java.util.Scanner;
 
public class Solution {
	static int n, m;
	static int answer;
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
         
        int testCase = 10;
         
        for(int t = 1; t<=testCase; t++) {
        	int testNumber = sc.nextInt();
            n = sc.nextInt();
            m = sc.nextInt();
            answer = 0;
            dfs(1, 0);
            System.out.printf("#%d %d\n", testNumber, answer);
        }
    }

    public static void dfs(int result, int depth) {
    	if(depth == m) {
    		answer = result;
    		return;
    	}
    	
    	dfs(result * n, depth+1);
    }
}