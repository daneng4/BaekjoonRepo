import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = 10;
		StringTokenizer st;
		
		for(int t = 1; t<= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<100; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list);
			
			while(list.peekLast() - list.peekFirst() > 1) {
				if(n == 0) {
					break;
				}
				
				list.addLast(list.pollLast() - 1);
				list.addFirst(list.pollFirst() + 1);
				Collections.sort(list);
				n-=1;
			}
			
			bw.write(String.format("#%d %d\n", t, list.peekLast() - list.peekFirst()));
		}
		
		bw.flush();
		bw.close();
	}	
}
