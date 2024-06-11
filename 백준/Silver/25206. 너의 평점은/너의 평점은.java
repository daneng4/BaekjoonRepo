
import java.util.*;
import java.io.*;

public class Main {
	
	static String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
	static double[] dgrade = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double totalScore = 0;
		double totalGetScore = 0;
		for(int i = 0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			
			String sub = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String getScore = st.nextToken();
			if(getScore.equals("P"))
				continue;
			totalScore += score;
			totalGetScore += changeToDecimal(getScore) * score;
		}
		
		System.out.println(totalGetScore / totalScore);
		
	}
	public static double changeToDecimal(String getScore) {
		double decimal = 0;
		
		int idx = 0;
		for(String score : grade) {
			if(score.equals(getScore)) {
				decimal = dgrade[idx];
				break;
			}
			idx++;
		}
		
		return decimal;
	}
}