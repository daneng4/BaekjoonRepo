
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int original = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			String[] operation = new String[10000];
			
			q.add(original);
			visited[original] = true;
			Arrays.fill(operation, "");
			
			while(!q.isEmpty() && !visited[target]) {
				int num = q.poll();
				
				int d = (num * 2) % 10000;
				int s = num == 0 ? 9999 : num -1;
				// num % 1000 -> d2d3d4, num / 1000 -> d1
				int l = (num % 1000) * 10 + num / 1000; 
				// num % 10 -> d4, num / 10 -> d2d3d4
				int r = (num % 10) * 1000 + num / 10;
				
				if(!visited[d]) {
					q.add(d);
					visited[d] = true;
					operation[d] = operation[num] + "D";
				}
				if(!visited[s]) {
					q.add(s);
					visited[s] = true;
					operation[s] = operation[num] + "S";
				}
				if(!visited[l]) {
					q.add(l);
					visited[l] = true;
					operation[l] = operation[num] + "L";
				}
				if(!visited[r]) {
					q.add(r);
					visited[r] = true;
					operation[r] = operation[num] + "R";
				}
			}
				
			System.out.println(operation[target]);	
		}
	}
}

