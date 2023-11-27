
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		for(int t = 0; t<test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> cloth = new HashMap<>();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken(); // 옷
				String b = st.nextToken(); // 옷 종류
				
				if(cloth.containsKey(b)) {
					cloth.put(b, cloth.get(b) + 1);
				}else {
					cloth.put(b, 1);
				}
			}
			int result = 1;
			int sum = 0;
			for(int value : cloth.values()) {
				result *= (value+1);
			}
			System.out.println(result-1);
		} // end of testcase for loop
		
	}
}
