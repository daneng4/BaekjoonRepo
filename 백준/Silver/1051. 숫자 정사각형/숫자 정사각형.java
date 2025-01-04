import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][m];
    	
    	for(int i = 0; i<n; i++) {
    		String[] str = br.readLine().split("");
    		for(int j = 0; j<m; j++) {
    			map[i][j] = Integer.parseInt(str[j]);
    		}
    	}
    	
    	int len;
    	// n과 m중 더 작은 것을 기준으로 범위 설정
    	if(n > m) {
    		len = m;
    	}else {
    		len = n;
    	}
    	
    	while(len > 1) {
            for(int i=0; i<= n-len; i++) {
                for(int j=0; j<=m-len; j++) {
                    int num = map[i][j];
                    // 꼭짓점 3군데 비교
                    if(num==map[i][j+len-1] && num == map[i+len-1][j] && num == map[i+len-1][j+len-1]) {
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--;
        }
    	
    	System.out.println(len);
    }
}