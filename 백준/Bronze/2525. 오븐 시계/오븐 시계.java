
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		// min + time 이 59 이하라면
		if(min + time <= 59) {
			min += time;
			System.out.println(hour + " " + min);
		}
		else {
			hour += (min+time)/60;
			min = (min+time) % 60;
			System.out.println(hour % 24 + " " + min);
		}
		
	}
}