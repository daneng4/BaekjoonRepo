import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+2];
		arr[0] = 0;
		for(int i = 1; i<=n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n+1] = l;
		Arrays.sort(arr);

		// 고속도로의 끝에는 휴게소를 세우지 않는다, 0과 l을 제외
		int left = 1;
		int right = l-1;
		while(left <= right){
			// 기준은 휴게소 사이의 간격
			int mid = (left + right) / 2;
			int sum = 0;
			for(int i = 1; i<arr.length; i++){
				sum += (arr[i] - arr[i-1] - 1) / mid;
			}

			if(sum > m){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		System.out.println(left);
	}
}
