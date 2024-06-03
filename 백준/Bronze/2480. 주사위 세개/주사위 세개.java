import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(a, map.getOrDefault(a, 0) + 1);
		map.put(b, map.getOrDefault(b, 0) + 1);
		map.put(c, map.getOrDefault(c, 0) + 1);

		int answer = 0;
		if(map.size() == 3) {
			int max = 0;
			for(Integer key : map.keySet()) {
				max = Math.max(max, key);
			}
			answer = max * 100;
		}else if(map.size() == 2) {
			for(Integer key : map.keySet()) {
				if(map.get(key) == 2) {
					answer = 1000 + key * 100;
				}
			}
		}else {
			for(Integer key : map.keySet()) {
				answer = 10000 + key * 1000;
			}
		}
	
		System.out.println(answer);
	}
}