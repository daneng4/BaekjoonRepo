
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //데이터 개수
		int time[] = new int[n];
		int sum[] = new int[n];
		for(int i = 0; i<n; i++) {
			time[i] = sc.nextInt();
		}
		// time을 오름차순 정렬을 했을때가 가장 시간비용이 적다.
		for(int i = 1; i<n; i++) {
			int insert_point = i; // 정렬 대상 index
			int insert_value = time[i]; // 정렬 대상 data
			
			for(int j = i-1; j>=0; j--) {
				if (time[j] < time[i]) {
					insert_point = j+1;
					break;
				}
				
				if(j == 0) {
					insert_point = 0;
				}
			}
			for(int j = i; j > insert_point; j--) { //배열 shift
				time[j] = time[j-1];
			}
			time[insert_point] = insert_value;
		}
		sum[0] = time[0];
		for(int i = 1; i<n; i++) {
			sum[i] = sum[i-1] + time[i];
		}
		int total_time = 0;
		for(int i = 0; i <n; i++) {
			total_time += sum[i];
		}
		System.out.println(total_time);
	}
}

