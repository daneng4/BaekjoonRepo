
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		int team_num = sc.nextInt(); //팀의 개수
		int students[] = new int[team_num*2];
		
		for(int i = 0; i<students.length; i++) {
			students[i] = sc.nextInt();
		}
		Arrays.sort(students);
		int min = 1000001;
		for(int i = 0; i<team_num; i++) {
			int partner = students[students.length-1-i];
			if((students[i] + partner) < min)
				min = students[i]+partner;
		}
		System.out.println(min);
		
	}
}

