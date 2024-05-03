import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = 10;

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<n; i++) {
				list.add(st.nextToken());
			}
			
			int opLen = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<opLen; i++) {
				String op = st.nextToken();
				int pos = Integer.parseInt(st.nextToken());
				int addict = Integer.parseInt(st.nextToken());
				
				if(op.equals("I")) {
					for(int j = 0; j<addict; j++) {
						String newElement = st.nextToken();
						list.add(pos++, newElement);
					}
				}else {
					for(int j = 0; j<addict; j++) {
						list.remove(pos);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		} // testcase
		bw.flush();
	}
}