
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[10001];
		
		for(int i = 0; i<n; i++) {
			list[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i<list.length; i++) {
			if(list[i] > 0) {
				for(int j = 0; j<list[i]; j++)
					bw.write(i + "\n");
			}
		}
		
		
		bw.flush();
	}

}