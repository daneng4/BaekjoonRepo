
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 숫자를 섞었을 때 30의 배수가 등장하는 수는
		// 0을 포함하고있으며 모든 자릿수를 더했을 때 3의 배수가 되는 수다.
		String[] str = br.readLine().split("");
		int[] num = new int[10];
		int sum = 0;
		for(int i = 0; i<str.length; i++) {
			int n = Integer.parseInt(str[i]);
			num[n]++;
			sum+=n;
		}
		
		if(num[0] == 0 || sum%3 != 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 9; i>=0; i--) {
			while(num[i] > 0) {
				sb.append(i);
				num[i]--;
			}
		}
		
		System.out.println(sb.toString());
	}
}
