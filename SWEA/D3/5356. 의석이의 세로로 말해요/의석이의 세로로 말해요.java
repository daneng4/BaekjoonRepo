
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			ArrayList<char[]> list = new ArrayList<>();
			int max = 0;
			for(int i = 0; i<5; i++) {
				String str = br.readLine();
				max = Math.max(str.length(), max);
				list.add(str.toCharArray());
			}
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i<max; i++) {
				for(int j = 0; j<5; j++) {
					// 해당 문자열의 마지막 인덱스가 현재 i보다 작은 경우 패스
					if(list.get(j).length-1 < i)
						continue;
					sb.append(list.get(j)[i]);
				}
			}
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		}
		bw.flush();
	}
}