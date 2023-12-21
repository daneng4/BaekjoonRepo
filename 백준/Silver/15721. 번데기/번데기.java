
import java.io.*;
import java.util.*;

public class Main {
	
	static int A;
	static int T;
	static int n;
	static int zero,one;
	static int repeat = 2;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Integer.parseInt(br.readLine()); // 사람 수
		T = Integer.parseInt(br.readLine()); // 구하고자하는 번째
		n = Integer.parseInt(br.readLine()); // 구하고자 하는 구호 0 = 뻔, 1 = 데기
		
		int result = solve();
		System.out.println(result);
		
		
	}
	public static int solve() {
		while(true) {
			for(int i = 0; i<4; i++) {
				if(i%2==0) {
					zero++;
				}else {
					one++;
				}
				
				if(n == 0 && zero == T) { // 구하고자하는게 뻔이고, T번째 인 경우
					return (zero+one-1)%A; 
				}
				if(n == 1 && one == T) {
					return (zero + one - 1 ) % A;
				}
			}
			
			for(int i = 0; i<repeat; i++ ) {
				zero++;
				if(zero== T && n == 0) {
					return (zero + one-1) %A;
				}
			}
			for(int i = 0; i<repeat; i++ ) {
				one++;
				if(one== T && n == 1) {
					return (zero + one-1) %A;
				}
			}
			repeat++;
		}
		
	}
}
