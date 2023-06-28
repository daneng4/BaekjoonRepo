import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		// 분이 45분 이하일때
		if (M < 45) {
			M = M + 60 - 45;
			
			if (H == 0) { // 45분 미만인데 H가 0인경우
				H = 23;
			}else {
				H = H - 1;
			}
		}else {
			M = M - 45;
		}
		
		System.out.println(H + " " + M);
	}
}