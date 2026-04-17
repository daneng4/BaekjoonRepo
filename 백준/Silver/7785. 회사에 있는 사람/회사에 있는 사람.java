import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> office = new HashSet<>();
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String status = st.nextToken();
			
			if(status.equals("enter")) {
				office.add(name);
			}else {
				office.remove(name);
			}
		}
		
		print(office);
	}
	public static void print(Set<String> office) {
		office.stream()
			.sorted(Collections.reverseOrder())
			.forEach(System.out::println);
	}
}