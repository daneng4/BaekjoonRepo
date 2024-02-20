
import java.io.*;
import java.util.*;

public class Main {
	static int[] height;
	static int sum = 0;
	public static void main(String[] args) throws Exception  {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		height = new int[w];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 현재 블록의 왼쪽에서 가장 높이가 높은 것과
		// 오른쪽에서 가장 높이가 높은 블록을 찾고
		// 둘중 min 값을 기준으로 min - 각 위치의 높이를 한다.
		for(int i = 1; i<height.length; i++) {
			int left = 0;
			int right = 0;
			
			// 왼쪽 탐색
			for(int cur = 0; cur<=i-1; cur++) {
				left = Math.max(height[cur], left);
			}
			// 오른쪽 탐색
			for(int cur = i+1; cur<height.length; cur++) {
				right = Math.max(height[cur], right);
			}
			
			// 둘중 작은 값을 기준으로 고인물 구함
			int min = Math.min(left, right);
			if(min - height[i] > 0)
				sum += min - height[i];
		}
			
		
		System.out.println(sum);
		
	}

}




