
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 0; i<n; i++) {
			ArrayList<Character> list = new ArrayList<>();
			String str = br.readLine();
			boolean notGroup = false;
			
			for(int j = 0; j<str.length(); j++) {
				if(!list.contains(str.charAt(j))) {
					list.add(str.charAt(j));
				}else {
					if(str.charAt(j-1) == str.charAt(j)) {
						continue;
					}
					notGroup = true;
					break;
				}
			}
			if(notGroup)
				continue;
			count++;
		}
		
		System.out.println(count);
		
	}
}