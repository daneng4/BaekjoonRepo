import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		String[] str = new String[n];

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[m];
			for(int j = 0; j<m; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			String pattern = "";
			for(int j = 0; j<m-1; j++) {
				int a = arr[j];
				for(int k = j+1; k<m; k++) {
					int b = arr[k];
					if(a > b) {
						pattern += "-";
					}else if(a == b) {
						pattern += "=";
					}else {
						pattern += "+";
					}
				}
			}
			
			str[i] = pattern;
		}
		
		for(int i = 0; i<n-1; i++) {
			for(int j = i+1; j<n; j++) {
				if(str[i].equals(str[j])) {
					answer += 1;
				}
			}
		}
		
		System.out.println(answer);
    }
}
