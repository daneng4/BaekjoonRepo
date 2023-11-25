
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] sort;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sort = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = sort[i] = num;
		}
		Arrays.sort(sort);
		int count = 0;
		
		for(int v : sort) {
			if(!map.containsKey(v)) {
				map.put(v, count);
				count++;
			}
		}
		for(int key : arr) {
			if(map.containsKey(key)) {
				sb.append(map.get(key)).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
