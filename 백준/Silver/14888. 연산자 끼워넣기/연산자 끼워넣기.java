
import java.io.*;
import java.util.*;

public class Main {
	public static int[] numbers;
	public static int[] oper = new int[4];
	public static int n;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());		
		for(int i = 0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		find(numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void find(int num, int idx) {
		if(idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(oper[i] > 0) {
				
				oper[i]--;
				
				switch(i) {
				case 0 : find(num + numbers[idx], idx + 1); break;
				case 1 : find(num - numbers[idx], idx + 1); break;
				case 2 : find(num * numbers[idx], idx + 1); break;
				case 3 : find(num / numbers[idx], idx + 1); break;
				}
				oper[i]++;
			}
		} // end of loop
		
	}
	

}
