
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] isExist = new boolean[31];
		for(int i = 0; i<28; i++) {
			int num = Integer.parseInt(br.readLine());
			isExist[num] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < isExist.length; i++) {
			if(!isExist[i])
				sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}