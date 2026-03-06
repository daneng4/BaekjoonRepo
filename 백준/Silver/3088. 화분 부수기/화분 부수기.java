import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[1000001];
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			
			int value1 = Integer.parseInt(input[0]);
			int value2 = Integer.parseInt(input[1]);
			int value3 = Integer.parseInt(input[2]);
				
			if(!check[value1] && !check[value2] && !check[value3]) {
				answer++;
			}
			
			check[value1] = true;
			check[value2] = true;
			check[value3] = true;
		}
		
		System.out.println(answer);
	}
}
