
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String search = br.readLine();

		//ababababa = doc
		//aba = search
		int start = 0;
		int end = start + search.length();
		int len = doc.length();
		int count = 0;
		while(end <= len) {
			String substring = doc.substring(start, end);
			if(search.equals(substring)) {
				count++;
				start = end;
				end = end + search.length();
			}else {
				start++;
				end++;
			}
		}
		System.out.println(count);
	}
}

