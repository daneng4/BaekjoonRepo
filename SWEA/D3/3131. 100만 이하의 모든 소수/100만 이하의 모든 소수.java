
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		boolean isPrime = true;
		
		for(int i = 2; i<1000000; i++) {
			isPrime = true;
			for(int j = 2; j<= Math.sqrt(i); j++) {
				// 1과 자기자신이 아닌 수로 나뉘면 소수가 아님, 여기서 1은 제외
				if(j != i && i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}