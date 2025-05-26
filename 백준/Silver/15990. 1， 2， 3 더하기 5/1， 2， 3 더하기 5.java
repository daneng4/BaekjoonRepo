import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 100_001;
		int mod = 1_000_000_009;
		long[][] arr = new long[max][4];
		arr[1][1] = 1;
		arr[2][2] = 1;
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[3][3] = 1;

		for(int i = 4; i<max; i++){
			arr[i][1] = (arr[i-1][2] + arr[i-1][3]) % mod;
			arr[i][2] = (arr[i-2][1] + arr[i-2][3]) % mod;
			arr[i][3] = (arr[i-3][1] + arr[i-3][2]) % mod;
		}

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(n-- > 0){
			int num = Integer.parseInt(br.readLine());
			sb.append((arr[num][1] + arr[num][2] + arr[num][3]) % mod).append("\n");
		}

		System.out.println(sb);
	}
}
