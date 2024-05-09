import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] arr = st.nextToken().toCharArray();
			int k = Integer.parseInt(st.nextToken());
			int pos = 0;
			
			// 처음 방울 위치 확인
			for(int i = 0; i<arr.length; i++) {
				if(arr[i] == 'o') {
					pos = i;
					break;
				}
			}
			int answer = 0;
			// 방울이 양쪽 끝에서 시작했다면
			if(pos == 0 || pos == 2) {
				if(k == 0) 
					answer = pos;
				else if(k % 2 == 0)
					answer = 0; // 방울 위치 = 왼쪽
				else if(k % 2 == 1)
					answer = 1; // 방울 위치 = 가운데
			}
			// 방울이 가운데에서 시작했다면
			else {
				if(k == 0)
					answer = pos;
				else if(k % 2 == 0)
					answer = 1; // 방울 위치 = 가운데
				else if(k % 2 == 1)
					answer = 0;
			}
			
			bw.write(String.format("#%d %d\n", t, answer));
		} // testcase
		bw.flush();
			
	}
}
