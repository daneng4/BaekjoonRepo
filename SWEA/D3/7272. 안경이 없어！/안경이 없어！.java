
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			ArrayList<Character> one = new ArrayList<>();
			ArrayList<Character> two = new ArrayList<>();
			
			one.add('A'); one.add('D'); one.add('O'); one.add('P');
			one.add('Q'); one.add('R');
			
			two.add('B');
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] left = st.nextToken().toCharArray();
			char[] right = st.nextToken().toCharArray();
			
			if(left.length != right.length) {
				bw.write(String.format("#%d DIFF\n", t));
				continue;
			}
			
			boolean isSame = true;
			for(int i = 0; i<left.length; i++) {
				char lc = left[i];
				char rc = right[i];
				int leftHole = 0; int rightHole = 0;
				
				if(one.contains(lc)) {
					leftHole = 1;
				}else if(two.contains(lc)){
					leftHole = 2;
				}
				
				if(one.contains(rc)) {
					rightHole = 1;
				}else if(two.contains(rc)){
					rightHole = 2;
				}
				
				if(leftHole != rightHole) {
					isSame = false;
					break;
				}
			}
			
			if(isSame) {
				bw.write(String.format("#%d SAME\n", t));
			}else {
				bw.write(String.format("#%d DIFF\n", t));
			}
			
		} // testcase
		bw.flush();
	}
}