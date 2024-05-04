import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] code = new int[n][m];
			list = new ArrayList<>();
			init();
			for(int i = 0; i<n; i++) {
				String str = br.readLine();
				for(int j = 0; j<m; j++) {
					code[i][j] = str.charAt(j)-'0';
				}
			}
			boolean isFind = false;
			int sum = 0;
			int original = 0;
			
			for(int i = 0; i<n; i++) {
				for(int j = m-1; j >= 55; j--) {
					// 암호의 가장 마지막(56번째 자리)은 항상 1임을 이용
					if(code[i][j] == 1) {
						// 1을 찾은 경우 해당 자리부터 56자리를 탐색
						isFind = true;
						int count = 0;
						int curNum = 0;
						StringBuilder sb = new StringBuilder();
						
						for(int k = 0; k<56; k+=7) {
							for(int r = 6; r>=0; r--) {
								sb.append(code[i][j-k-r]);
							}
							for(int a = 0; a<=9; a++) {
								if(list.get(a).equals(sb.toString())) {
									curNum = a;
									break;
								}
							}
							if(count % 2 == 0) {
								sum += curNum;
								original += curNum;
								count++;
							}else {
								sum += curNum * 3;
								original += curNum;
								count++;
							}
							sb.setLength(0);
						}
						break;
					}
				}
				if(isFind)
					break;
			}
			
			if(sum % 10 == 0)
				bw.write(String.format("#%d %d\n", t, original));
			else
				bw.write(String.format("#%d 0\n", t));
			
		} // testcase
		bw.flush();
	}
	public static void init() {
		list.add("0001101");
		list.add("0011001");
		list.add("0010011");
		list.add("0111101");
		list.add("0100011");
		list.add("0110001");
		list.add("0101111");
		list.add("0111011");
		list.add("0110111");
		list.add("0001011");
	}
}