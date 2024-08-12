
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			list.add(Integer.parseInt(s));
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int num : list) {
			sum += num / t;
			if(num % t > 0)
				sum+=1;
		}
		
		int answer = n / p;
		int remain = n % p;
		
		System.out.println(sum);
		System.out.println(answer + " " + remain);
		
	}
}