
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		String str = "[A-F]?A+F+C+[A-F]?$";
		//[A-F]? -> A~F중 문자가 있거나 없다
		//A+F+C+ -> A,F,C 문자가 1개 이상 있다
		//$ -> 문자열의 끝
		
		StringBuilder sb = new StringBuilder();
		
		while(size --> 0) {
			sb.append(br.readLine().matches(str) ? "Infected!" : "Good").append("\n");
		}
		System.out.print(sb);
	}
}
