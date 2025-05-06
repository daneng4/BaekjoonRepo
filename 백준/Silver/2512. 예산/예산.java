import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		// 배정된 예산들의 합이 예산 총액보다 적으면 최대값 반환
		if(sum <= m){
			System.out.println(arr[n-1]);
			return;
		}

		int min = 0;
		int max = arr[n-1];
		int answer = 0;
		while(min <= max){
			int middle = (min + max) / 2;
			int total = 0;
			for(int i = 0; i<n; i++){
				if(arr[i] <= middle)
					total += arr[i];
				else
					total += middle;
			}

			// 예산 총액보다 돈이 더 필요하면 예산을 줄여야
			if(total > m){
				max = middle - 1;
			}
			// 예산 총액보다 total이 적으면 예산을 좀 더 늘려본다
			else{
				answer = Math.max(answer, middle);
				min = middle + 1;
			}
		}

		System.out.println(answer);
	}
}
