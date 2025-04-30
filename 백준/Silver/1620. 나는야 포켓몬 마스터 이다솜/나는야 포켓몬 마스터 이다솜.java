
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr = new String[n+1];
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 1; i<=n; i++) {
			String name = br.readLine();
			map.put(name, i);
			arr[i] = name;
		}
		
		for(int i = 0; i<m; i++) {
			String input = br.readLine();
			if(isNumeric(input)) { // 입력 값이 자연수면
				int key = Integer.parseInt(input);
				String result = arr[key]; // 포켓몬 도감 번호로 포켓몬 이름을 get
				sb.append(result).append("\n");
			}else { // 입력 값이 문자열이면
				int result = map.get(input); // 포켓몬 이름으로 도감 번호를 get
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}
	public static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
