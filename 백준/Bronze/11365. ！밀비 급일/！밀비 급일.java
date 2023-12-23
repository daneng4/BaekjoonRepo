
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		String end = "END";
		while((input = br.readLine()) != end) {
			if(input.equals(end)) {
				break;
			}
			String[] arr = input.split("");
			for(int i = arr.length-1; i>-1; i--) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		
	}
	
}
