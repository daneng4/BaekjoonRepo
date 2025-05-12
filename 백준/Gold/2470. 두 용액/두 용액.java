import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		int num1 = 0;
		int num2 = 0;

		int left = 0;
		int right = n-1;
		while(left < right){
			int sum = arr[left] + arr[right];
			if(diff > Math.abs(sum)){
				diff = Math.abs(sum);
				num1 = arr[left];
				num2 = arr[right];

				if(diff == 0)
					break;
			}
			if(sum < 0)
				left++;
			else
				right--;
		}

		System.out.println(num1 + " " + num2);
	}
}
