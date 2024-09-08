import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> names = new HashMap<>();
		int total = 0;
		
		for(int i = 0; i<n; i++) {
			char firstName = br.readLine().charAt(0);
			names.put(firstName, names.getOrDefault(firstName, 0) + 1);
		}
		
		for(Entry<Character, Integer> name : names.entrySet()) {
			int cnt = name.getValue();
			if(cnt >= 5) {
				total+=1;
				bw.write(name.getKey());
			}
		}
		
		if(total != 0) {
			bw.flush();
		}else {
			bw.write("PREDAJA");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}

}