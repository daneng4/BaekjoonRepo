
import java.io.*;
import java.util.*;

public class Main {
		
	private static int[] score;
	private static int n;
	private static int[] maxDP;
	private static int[] minDP;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int[] preMax;
	private static int[] preMin;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		score = new int[3];
		maxDP = new int[3];
		minDP = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<3; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		initDP();
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				score[j] = Integer.parseInt(st.nextToken());
			}	
			find(i);
		}

		
		max = Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]);
		min = Math.min(Math.min(minDP[0], minDP[1]), minDP[2]);
			
		System.out.printf("%d %d", max, min);
	}
	
	public static void initDP() {
		for(int i = 0; i<3; i++) {
			minDP[i] = score[i];
			maxDP[i] = score[i];
		}
	}
	
	public static void find(int stage) {
		preMax = maxDP.clone();
		preMin = minDP.clone();
		for(int i = 0; i<3; i++) {
			if(i == 0) {
				int num1 = preMax[i];
				int num2 = preMax[i+1];
				int a = preMin[i];
				int b = preMin[i+1];
				maxDP[i] = Math.max(num1, num2) + score[i];
				minDP[i] = Math.min(a, b) + score[i];
			}
			else if (i == 1) {
				int num1 = preMax[i-1];
				int num2 = preMax[i];
				int num3 = preMax[i+1];
				int a = preMin[i-1];
				int b =	preMin[i];
				int c =	preMin[i+1];
				maxDP[i] = score[i] + Math.max(Math.max(num1, num2), num3);
				minDP[i] = score[i] + Math.min(Math.min(a, b), c);
			}
			else {
				int num1 = preMax[i-1];
				int num2 = preMax[i];
				int a = preMin[i-1];
				int b = preMin[i];
				maxDP[i] = Math.max(num1, num2) + score[i];
				minDP[i] = Math.min(a, b) + score[i];
			}
			
		} // end of for loop	
	}
	
}
