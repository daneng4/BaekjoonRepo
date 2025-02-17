import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		Schedule[] s = new Schedule[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			
			s[i] = new Schedule(day, pay);
		}
		
		Arrays.sort(s);
		int answer = 0;
		boolean[] check = new boolean[10001];
		for(int i = 0; i<n; i++) {
			for(int j = s[i].day; j>=1; j--) {
				if(!check[j]) {
					check[j] = true;
					answer += s[i].pay;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
class Schedule implements Comparable<Schedule>{
	int day;
	int pay;
	public Schedule(int day, int pay) {
		this.day = day;
		this.pay = pay;
	}
	public int compareTo(Schedule s) {
		if(this.pay == s.pay) {
			return s.day - this.day;
		}
		return s.pay - this.pay;
	}
}