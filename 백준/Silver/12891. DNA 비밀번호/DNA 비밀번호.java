import java.io.*;
import java.util.*;

public class Main {
	private static int answer = 0;
	private static int[] minArr;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String dna = br.readLine();
		minArr = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			minArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<P; i++) {
			char c = dna.charAt(i);
			if(c == 'A') minArr[0]--;
			if(c == 'C') minArr[1]--;
			if(c == 'G') minArr[2]--;
			if(c == 'T') minArr[3]--;
		}
		
		checkCondition();
		int i = -1;
		
		for(int j = P; j<S; j++) {
			// 이전 부분 문자열의 시작 위치
			i = j - P;
			
			char pre = dna.charAt(i);
			if(pre == 'A') minArr[0]++;
			if(pre == 'C') minArr[1]++;
			if(pre == 'G') minArr[2]++;
			if(pre == 'T') minArr[3]++;
			
			char next = dna.charAt(j);
			if(next == 'A') minArr[0]--;
			if(next == 'C') minArr[1]--;
			if(next == 'G') minArr[2]--;
			if(next == 'T') minArr[3]--;
			
			checkCondition();
		}
		
		System.out.println(answer);
	}
	private static void checkCondition() {
		for(int i = 0; i<4; i++) {
			if(minArr[i] > 0)
				return;
		}
		
		answer += 1;
		return;
	}
}