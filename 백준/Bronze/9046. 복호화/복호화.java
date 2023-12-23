
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> repo = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			repo = new HashMap<>();
			String[] arr = br.readLine().split("");
			
			for(String str : arr) {
				if(str.equals(" "))
					continue;
				repo.put(str, repo.getOrDefault(str, 0)+1);
			}
			StringBuilder sb = new StringBuilder();
			int maxValue = Collections.max(repo.values());
			for(Map.Entry<String, Integer> e : repo.entrySet()) {
				if(e.getValue() == maxValue) {
					sb.append(e.getKey());
				}
			}
			
			if(sb.length() == 1) {
				System.out.println(sb);
			}else {
				System.out.println("?");
			}
			
		}
		
		
	}
	
}
