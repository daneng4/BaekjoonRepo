
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a,b});
			}
			
			sb.append(String.format("#%d ", t));
			int p = Integer.parseInt(br.readLine());
			for(int i = 0; i<p; i++) {
				int bus = Integer.parseInt(br.readLine());
				int count = 0;
				
				for(int j = 0; j<list.size(); j++) {
					if(list.get(j)[0] <= bus && bus <= list.get(j)[1])
						count++;
				}
				sb.append(count).append(" ");
			}
			
			bw.write(String.format("%s\n", sb.toString()));
		}
		
		bw.flush();
	}
}