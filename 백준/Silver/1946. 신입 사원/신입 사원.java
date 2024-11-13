
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t<T; t++) {
			ArrayList<int[]> list = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a,b});
			}
			
			Collections.sort(list, (a,b) -> a[0] - b[0]);
			
			int min = Integer.MAX_VALUE;
			int answer = 0;
			for(int[] grade : list) {
				if(grade[1] < min) {
					answer++;
					min = Math.min(grade[1], min);
				}
			}
			
			System.out.println(answer);
		}
	}
}