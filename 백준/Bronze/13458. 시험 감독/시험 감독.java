import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 시험장 수
        int[] students = new int[n];
        long sum = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine()); // 학생 수들
        for(int i = 0; i<n; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken()); // 총감독이 관리할 수 있는 학생 수
        int c = Integer.parseInt(st.nextToken()); // 부감독이 관리할 수 있는 학생 수
        
        for(int i = 0; i<n; i++){
            students[i] = students[i] - b;
            sum = sum + 1; // 총감독 1명
            if(students[i] <= 0)
                continue;
            
            if(students[i] % c > 0){
                sum = sum+(students[i]/c) + 1; // 나머지가 있으면 부감독 + 1
            }else{
                sum = sum + (students[i]/c); // 나머지 없으면 부감독 = 몫
            }
        }
        System.out.println(sum);
	}
}
