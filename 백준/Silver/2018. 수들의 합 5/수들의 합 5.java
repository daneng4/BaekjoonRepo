import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		int sum = 1;
		
		int start = 1;
		int end = 1;
		
		 while (end != n) { // end가 입력 값 n과 같은 경우 종료
			 if (sum == n) { // 숫자들의 합이 입력 값 n과 같을 때
				 count++;
				 end++;
				 sum += end;
			 }
			 
			 else if(sum > n) { // 숫자들의 합이 입력 값 n보다 큰 경우
				 sum -= start;
				 start++;
			 }
			 else { // 숫자들의 합이 입력 값 n보다 작은 경우
				 end++;
				 sum += end;
			 }
		 }
		System.out.println(count);
		
	}
}
