

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] area = new int[1001];
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			area[Integer.parseInt(st.nextToken())] = 1;
		}
		
		for(int i = 1; i<=1000; i++) {
			if(area[i] != 0) {
				i+=l-1;
				answer++;
			}
		}
		
		System.out.println(answer);

	}
}
