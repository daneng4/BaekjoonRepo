import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int fn = sc.nextInt(); // 시험을 본 과목의 개수
		int scores[] = new int[fn];
		long max=0;
		long sum=0;
		
		for(int i = 0; i< fn; i++) {
			scores[i] = sc.nextInt();
		}
		
		for(int i = 0; i< scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
			sum = sum + scores[i];
		}
		System.out.println(sum*100.0/max/fn);
	}

}
