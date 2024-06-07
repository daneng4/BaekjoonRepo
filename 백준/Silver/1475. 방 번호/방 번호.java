import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<str.length; i++) {
			int num = str[i] - '0';
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// map 중에서 최대 value 찾기
		int answer = 0;
		int sum69 = 0;
		int max = 0;
		for(Integer key : map.keySet()) {
			if(key == 6 || key == 9) {
				sum69 += map.get(key);
			}else {
				max = Math.max(max, map.get(key));
			}
		}

		answer = Math.max(max, (sum69 / 2) + (sum69 % 2));
		System.out.println(answer);
	}

}