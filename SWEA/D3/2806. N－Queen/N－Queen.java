import java.io.*;
import java.util.*;

public class Solution {
	static int ans = 0;
    static int[] chess;
    static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++){
            ans = 0;

            N = Integer.parseInt(br.readLine());
            chess = new int[N];

            dfs(0);

            bw.write(String.format("#%d %d\n", test_case, ans));
        }
		bw.flush();
		bw.close();
		
	}	
	static void dfs(int depth){
        if(depth == N){
            ans++;
            return;
        }

        for(int i=0;i<N;i++){
            chess[depth] = i;
            if(isPossible(depth)){
                dfs(depth + 1);
            }
        }
    }
    static boolean isPossible(int depth){
        for(int i=0;i<depth;i++){
            if(chess[i] == chess[depth] ||depth - i == Math.abs(chess[depth]- chess[i])){
                return false;
            }
        }
        return true;
    }
}
