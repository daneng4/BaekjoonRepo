import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 투포인터?
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] elements = new int[n];
		for(int i = 0; i<n; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(elements);
		int start = 0; int end = elements.length-1;
		int answer = 0;
		
		while(start < end) {
			int sum = elements[start] + elements[end];
			if(sum < m) {
				start += 1;
			}else if(sum > m) {
				end -= 1;
			}else {
				answer+=1;
				start +=1; 
				end -= 1;
			}
		}
		
		System.out.println(answer);
	}
}