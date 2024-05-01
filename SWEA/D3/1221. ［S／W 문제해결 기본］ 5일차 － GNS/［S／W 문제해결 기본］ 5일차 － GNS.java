
import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static String[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			String testCaseNumber = st.nextToken();
			sb.append(testCaseNumber).append("\n");
			
			int len = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[len];
			answer = new String[len];

			for (int i = 0; i < len; i++) {
				String newNumber = st.nextToken();
				newNumberToDecimal(newNumber, i);
			}
			Arrays.sort(arr);
			decimalToNewNumber(arr);
			
			
			for(String num : answer) {
				sb.append(num).append(" ");
			}
			bw.write(String.format("%s", sb.toString()));
		}
		bw.flush();
	}

	public static void newNumberToDecimal(String newNumber, int idx) {
		switch (newNumber) {
		case "ZRO":
			arr[idx++] = 0;
			break;
		case "ONE":
			arr[idx++] = 1;
			break;
		case "TWO":
			arr[idx++] = 2;
			break;
		case "THR":
			arr[idx++] = 3;
			break;
		case "FOR":
			arr[idx++] = 4;
			break;
		case "FIV":
			arr[idx++] = 5;
			break;
		case "SIX":
			arr[idx++] = 6;
			break;
		case "SVN":
			arr[idx++] = 7;
			break;
		case "EGT":
			arr[idx++] = 8;
			break;
		case "NIN":
			arr[idx++] = 9;
			break;
		}
	}

	public static void decimalToNewNumber(int[] arr) {
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 0:
				answer[idx++] = "ZRO";
				break;
			case 1:
				answer[idx++] = "ONE";
				break;
			case 2:
				answer[idx++] = "TWO";
				break;
			case 3:
				answer[idx++] = "THR";
				break;
			case 4:
				answer[idx++] = "FOR";
				break;
			case 5:
				answer[idx++] = "FIV";
				break;
			case 6:
				answer[idx++] = "SIX";
				break;
			case 7:
				answer[idx++] = "SVN";
				break;
			case 8:
				answer[idx++] = "EGT";
				break;
			case 9:
				answer[idx++] = "NIN";
				break;
			}
		}
	}

}