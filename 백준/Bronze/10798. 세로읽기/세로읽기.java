
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String input = "";
		while((input = br.readLine()) != null) {
			if(input.isEmpty())
				break;
			
			list.add(input);
		}
		int max = Integer.MIN_VALUE;
		for(String str : list) {
			if(str.length() > max)
				max = str.length();
		}
		
		for(int i = 0; i<max; i++) {
			for(int j = 0; j<5; j++) {
				String[] str = list.get(j).split("");
				if(str.length-1 < i)
					continue;
				sb.append(str[i]);
			}
		}
		
		System.out.println(sb);
		
 	}
}
