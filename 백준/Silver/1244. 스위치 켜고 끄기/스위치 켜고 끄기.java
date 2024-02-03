
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] light = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=n; i++) {
			String stat = st.nextToken();
			if(stat.equals("0"))
				light[i] = false;
			else
				light[i] = true;
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 남학생인 경우
			if(sex == 1) {
				// 배수 번호의 스위치 상태를 바꿈
				for(int j = num; j<light.length; j+=num) {
					light[j] = !light[j];
				}
			}// 여학생인 경우
			else {
				// 스위치 번호를 기준으로 좌우를 확인하여 서로 다를때까지 진행
				int seq = 1;
				while(num - seq > 0 && num + seq < light.length) {
					if(light[num-seq] == light[num+seq]) {
						light[num-seq] = !light[num-seq];
						light[num+seq] = !light[num+seq];
						seq++;
					}else {
						break;
					}
				}
				light[num] = !light[num];
			}
			
		} // 학생 스위치 바꾸는 루프 끝
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<light.length; i++) {
			if(light[i])
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}