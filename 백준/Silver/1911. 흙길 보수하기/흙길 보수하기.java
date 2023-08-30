
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(st.nextToken()); // 웅덩이 개수
       int L = Integer.parseInt(st.nextToken()); // 널빤지 길이
       
       int [][] arr = new int[N][2]; // 물 웅덩이 시작, 끝 위치 저장
       for(int i = 0; i<N; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   arr[i][0] = Integer.parseInt(st.nextToken());
    	   arr[i][1] = Integer.parseInt(st.nextToken());
    	   
       }
       Arrays.sort(arr, new Comparator<int []>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0])
				return Integer.compare(o1[1], o2[1]);
			return Integer.compare(o1[0], o2[0]);
			}
    	   
       });
       
       int panel = 0; // 널빤지 개수
       int range = 0;
       for(int i =0;i<N; i++) {
    	   if (arr[i][0] > range)
    		   range = arr[i][0];
    	   if (arr[i][1] >= range) {
    		   while(arr[i][1] > range) {
    			   range += L;
    			   panel ++;
    		   }
    	   }
       }
       System.out.println(panel);
       
    }
}
