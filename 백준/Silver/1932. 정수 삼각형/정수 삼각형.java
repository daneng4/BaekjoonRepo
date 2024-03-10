
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] tree = new int[n+1][n+1];
		int[][] ori = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=i; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				ori[i][j] = tree[i][j]; 
			}
		}
		
		// ori 배열을 tree.clone으로 생성하면 같은 주소값을 가리키게 되므로 불가
		// i = 층, j는 i층의 j번째를 뜻함
		// 부모숫자는 자기 아래층이며 자기와 같은 index, index+1인 수에 더해짐
		
		for(int i = 1; i<=n-1; i++) {
			for(int j = 1; j<=i; j++) {
				int parent = tree[i][j];
				int o1 = ori[i+1][j];
				int o2 = ori[i+1][j+1];
				int c1 = tree[i+1][j];
				int c2 = tree[i+1][j+1];
				tree[i+1][j] = Math.max(o1 + parent, c1);
				tree[i+1][j+1] = Math.max(o2 + parent, c2);
			}
		}
		
		int result = 0;
		for(int i = 1; i<=n; i++) {
			result = Math.max(result, tree[n][i]);
		}
		
		System.out.println(result);
	}	

}

