
import java.util.*;
import java.io.*;

public class Main {
	static char[] target;
	static char[] my;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<testcase; t++) {
			int len = Integer.parseInt(br.readLine());
			my = br.readLine().toCharArray(); // 초기
			target = br.readLine().toCharArray(); // 목표
			int bCount = 0;
			int cCount = 0;
			// 오셀로 길이만큼 검사 수행
			for(int i = 0; i<len; i++) {
				if(target[i] != my[i]) {
					if(my[i] == 'B')
						cCount++;
					else 
						bCount++;
				}
			}
			
			if(cCount >= bCount)
				sb.append(cCount).append("\n");
			else
				sb.append(bCount).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}