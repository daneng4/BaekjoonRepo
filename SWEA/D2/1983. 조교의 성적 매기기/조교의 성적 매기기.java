
import java.io.*;
import java.util.*;


public class Solution {
	public static Double[] student;
	public static String[] rank = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			student = new Double[n];
			double targetScore = 0;
			int targetNum = 0;
			
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int middle = Integer.parseInt(st.nextToken());
				int finalex = Integer.parseInt(st.nextToken());
				int hw = Integer.parseInt(st.nextToken());
				
				double sum = middle * 0.35 + finalex * 0.45 + hw * 0.20;
				student[i] = sum;
				if (i + 1 == num) {
					targetScore = sum;
				}
			}
			
			Arrays.sort(student, Collections.reverseOrder());
			for(int i = 0; i<student.length; i++) {
				if (student[i] == targetScore) {
					targetNum = i;
					break;
				}
			}
			targetNum = targetNum / (n/10);
			System.out.print("#" + tc + " " + rank[targetNum]);
			System.out.println("");
			
		}
		
	}
}
