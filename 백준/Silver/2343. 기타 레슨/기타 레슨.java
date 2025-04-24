import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] lessonList = new int[n];

		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lessonList[i] = Integer.parseInt(st.nextToken());
			right += lessonList[i];
			left = Math.max(left, lessonList[i]);
		}

		// 수를 나눌 범위 = 수의 합, 이 합을 정하고 숫자들을 분리했을 때, count가지로 나눠지게 됨
		// 이 count가 m보다 크면 수의 합을 늘려 분리되는 개수를 줄여야하고
		// 이 count가 m보다 작으면 수의 합을 줄여 분리되는 개수를 늘려야 함
		// 이 과정을 계속 수행해서 블루레이의 최소 값을 찾음
		while (left <= right) {
			int mid = (left + right) / 2;

			int count = getCount(n, lessonList, mid);

			if(count > m){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}

		System.out.println(left);
	}

	private static int getCount(int n, int[] lessonList, int mid) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (sum + lessonList[i] > mid) {
				sum = 0;
				count++;
			}
			sum += lessonList[i];
		}

		if(sum != 0)
			count++;
		return count;
	}
}
