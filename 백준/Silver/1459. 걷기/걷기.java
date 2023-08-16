
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt(); // 집의 x위치
		long y = sc.nextInt(); // 집의 y위치
		
		long w = sc.nextInt(); // 한 블록 가는데 걸리는 시간 w
		long s = sc.nextInt(); // 대각선으로 한 블록 가로지르는 시간 s
		
		// 1번째 방법, 도로를 따라서 가로나 세로로 한 블록 움직여서 이번 사거리에서 저 사거리로 움직이는 방법
		long walk1 = (x+y) * w;
		
		// 2번째 방법, 대각선으로 가로지르는 방법
		long walk2 = 0;
		if ((x+y) % 2 == 0) {
			walk2 = Math.max(x, y) * s;
		}else {
			walk2 = (Math.max(x, y) - 1) * s + w;
		}
		
		long walk3 = Math.min(x, y) * s + Math.abs(x-y) * w;
		
		System.out.println(Math.min(walk3, Math.min(walk1, walk2)));
		
	}
}

