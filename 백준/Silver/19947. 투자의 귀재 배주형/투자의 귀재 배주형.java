
import java.util.*;
import java.io.*;

public class Main {
	static int h;
	static int y;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		answer = 0;
		solve(h, 0);
	
		System.out.println(answer);
	}
	public static void solve(long nowH, int year) {
		if(year > y)
			return;
		
		if(year == y) {
			answer = Math.max(answer, nowH);
			return;
		}
		
		solve((long)(nowH * 1.05), year + 1);
		solve((long)(nowH * 1.20), year + 3);
		solve((long)(nowH * 1.35), year + 5);
	}
}