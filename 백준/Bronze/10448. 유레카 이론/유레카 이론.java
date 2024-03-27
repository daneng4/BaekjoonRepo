
import java.util.*;
import java.io.*;

public class Main {
	static int[] tnum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		tnum = new int[45];
		for(int i = 1; i<=44; i++) {
			tnum[i] = i*(i+1)/2;
		}
		
		for(int t = 0; t<tc; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(solve(num)).append("\n");
		}
		
		System.out.println(sb);
	}
	public static int solve(int num) {
		for(int i = 1; i<=44; i++) {
			for(int j = 1; j<=44; j++) {
				for(int k = 1; k<=44; k++) {
					if(tnum[i] + tnum[j] + tnum[k] == num)
						return 1;
				}
			}
		}
		return 0;
	}
}

