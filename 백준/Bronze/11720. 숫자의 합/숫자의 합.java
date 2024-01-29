
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;
		
		String[] arr = str.split("");
		for(int i = 0; i<n; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}

}
