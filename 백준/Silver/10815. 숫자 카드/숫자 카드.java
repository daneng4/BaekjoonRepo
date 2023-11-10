
import java.io.*;
import java.util.*;


public class Main {
	public static int[] card;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			int check = Integer.parseInt(st.nextToken());
			sb.append(bs(card, n, check) + " ");
		}
		System.out.println(sb);
	
	}
	public static int bs(int[] card, int n, int check) {
		int first = 0;
		int last = n-1;
		int mid = 0;
		
		while(first<=last) {
			mid = (first + last)/2;
			if(card[mid] == check) {
				return 1;
			}
			if(card[mid] < check) {
				first = mid+1;
			}
			if(card[mid] > check) {
				last = mid -1;
			}
		}
		return 0;
	}
}
