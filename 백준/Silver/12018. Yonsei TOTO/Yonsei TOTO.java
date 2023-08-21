
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 과목수 n 
		int m = sc.nextInt(); // 보유 마일 m
		int myMiles[] = new int[n]; // 수강신청에 성공하기 위해 준비해야할 마일들 
		// => 각 과목에서 수강을 할 수 있는 최소한의 마일(현재 신청한 마일 중 최소 마일 +1)을 구한다.
		
		
		while(n > 0) {
			int app_nums = sc.nextInt();
			int max_nums = sc.nextInt();
			Integer miles[] = new Integer[app_nums];

			for(int i = 0; i<app_nums; i++) {
				miles[i] = sc.nextInt();
			}
			Arrays.sort(miles, Collections.reverseOrder());
			if (app_nums >= max_nums)
				myMiles[n-1] = miles[max_nums - 1];
			else
				myMiles[n-1] = 1;
			n--;
		}
		
		Arrays.sort(myMiles);
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i < myMiles.length; i++){
			sum += myMiles[i];
			if(sum > m) {
				break;
			}
			count++;
		}
		System.out.println(count);

	}
}

