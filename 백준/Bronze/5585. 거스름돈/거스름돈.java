
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		// 500, 100, 50, 10, 5, 1
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int change = 1000 - money; // 거스름돈 = 1천엔 - 금액
		int changearr[] = {500,100,50,10,5,1};
		int changeCount = 0;
		
		for(int i = 0; i<changearr.length; i++){
			changeCount = changeCount + change/changearr[i];
			change %= changearr[i];
		}
			
		System.out.println(changeCount);
	}
}

