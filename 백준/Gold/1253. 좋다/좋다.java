import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 008 좋은수구하기
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int count = 0;
		long a[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(a);

		for (int k = 0; k < N; k++) {

			long find = a[k];
			int start = 0;
			int end = N - 1;
			
			while (start < end) {
				
				if (a[start] + a[end] == find) {
					
					if(start!=k && end!=k ) {
						count++;
						break;
					}else if(start == k) { 
						start ++;
					}else if(end == k) {	
						end --;
					}
				}		
			
				else if (a[start] + a[end] < find) {
					start++;
                }
			
				else{
					end--;
			    }
           }
		}
		System.out.println(count);
	}

}