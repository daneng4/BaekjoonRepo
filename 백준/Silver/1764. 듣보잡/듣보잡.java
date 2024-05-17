
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> d = new HashSet<>();
		ArrayList<String> db = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			d.add(br.readLine());
		}
		for(int i = 0; i<m; i++) {
			String b = br.readLine();
			if(d.contains(b))
				db.add(b);
		}
		
		Collections.sort(db);
		System.out.println(db.size());
		for(String dbj : db) {
			System.out.println(dbj);
		}
	}
}
