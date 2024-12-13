import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		// 증가하는 부분 수열 구하고 겹치지 않는 선에서 감소하는 부분수열?
		int[] udp = new int[n];
		int[] ddp = new int[n];
		
		udp[0] = 1;
		for(int i = 1; i < n; i++) {
			udp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					udp[i] = Math.max(udp[i], udp[j] + 1);
				}
			}
		}
		
		ddp[n-1] = 1;
		for(int i = n-2; i >= 0; i--) {
			ddp[i] = 1;
			for(int j = n-1; j >= i; j--) {
				if(arr[i] > arr[j]) {
					ddp[i] = Math.max(ddp[i], ddp[j] + 1);
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i<n; i++) {
			answer = Math.max(ddp[i] + udp[i], answer);
		}
		
		System.out.println(answer - 1);
	}
}