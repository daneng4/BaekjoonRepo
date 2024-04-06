
import java.util.*;
import java.io.*;

class health{
	int weight;
	int height;
	int biggerThanMe;
	health(int weight, int height, int biggerThanMe){
		this.weight = weight;
		this.height = height;
		this.biggerThanMe = biggerThanMe;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<health> list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new health(w,h,0));
		}
		
		for(int i = 0; i<n; i++) {
			int ih = list.get(i).height;
			int iw = list.get(i).weight;
			for(int j = 0; j<n; j++) {
				if(i==j) continue;
				
				int jh = list.get(j).height;
				int jw = list.get(j).weight;
				
				if(ih < jh && iw < jw) 
					list.get(i).biggerThanMe++;
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(health me : list) {
			sb.append(me.biggerThanMe + 1).append(" ");
		}
		
		System.out.println(sb);
	}
}
