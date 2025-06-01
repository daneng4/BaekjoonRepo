import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int cur = arr[start];

		while(true){
			// s보다 cur이 크면 길이 갱신하고 start + 1
			if(cur > s){
				answer = Math.min(answer, end - start + 1);
				cur -= arr[start];
				start += 1;
			}
			// s와 cur이 같으면 길이 갱신하고 end + 1
			else if(cur == s){
				answer = Math.min(answer, end - start + 1);
				end += 1;
				if(end == n) break;
				cur += arr[end];
			}
			// s보다 cur이 작으면 end + 1
			else {
				end += 1;
				if(end == n) break;
				cur += arr[end];
			}
		}

		if(answer == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(answer);
	}
}
