import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		long start = 1;
		long end = k;
		long answer = 0;
		while(start <= end){
			long middle = (start + end) / 2;
			long count = 0;
			for(int i = 1; i<=n; i++){
				count += Math.min(middle / i, n);
			}
			if(count < k){
				start = middle + 1;
			}else{
				answer = middle;
				end = middle - 1;
			}
		}

		System.out.println(answer);
	}
}
