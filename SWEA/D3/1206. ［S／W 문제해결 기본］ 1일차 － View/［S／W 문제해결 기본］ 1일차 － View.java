import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = 10;
		StringTokenizer st;
		
		for(int t = 1; t<=tc; t++) {
			int size = Integer.parseInt(br.readLine());
			int[] h = new int[size];
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			
			for(int i = 0; i<size; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i<size-2; i++) {
				int rs = checkHeight(h, i);
				answer += rs;
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
		bw.close();
	}
	public static int checkHeight(int[] h, int idx) {
		int cur = h[idx];
		int max = 0;
		for(int i = idx-2; i<=idx+2; i++) {
			if(i == idx) continue;
			max = Math.max(max, h[i]);
		}
		
		return cur > max ? cur-max : 0;
	}
}