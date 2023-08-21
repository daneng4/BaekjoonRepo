
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int choco = 1;
		
		while(choco < k) {
			choco = choco*2;
		}
		System.out.print(choco);
		int sum = 0;
		int count = 0;
		if(k == choco) { // 만약 K개와 산 초코의 정사각형 개수가 같으면 굳이 나눌필요없다.
			System.out.println(" " + 0);
		}
		else { // 다르다면
			while(choco > 1) {
				count++;
				choco = choco/2;
				sum = sum + choco;
				if(sum == k) {
					break;
				}
				else if(sum > k) {
					sum = sum - choco;;
				}
				
			}
		System.out.println(" "+ count);
		}
		
	}
}

