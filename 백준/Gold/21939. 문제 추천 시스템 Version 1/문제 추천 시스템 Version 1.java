import java.io.*;
import java.util.*;

public class Main {
	static class Problem implements Comparable<Problem>{
		int diff;
		int num;
		public Problem(int num, int diff){
			this.num = num;
			this.diff = diff;
		}
		public int compareTo(Problem p){
			if(this.diff == p.diff){
				return this.num - p.num;
			}
			return this.diff - p.diff;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		TreeSet<Problem> list = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());
			list.add(new Problem(num, diff));
			map.put(num, diff);
		}

		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if(command.equals("recommend")){
				String op = st.nextToken();
				if(op.equals("1")){
					sb.append(list.last().num + "\n");
				}else{
					sb.append(list.first().num + "\n");
				}
			}else if(command.equals("add")){
				int num = Integer.parseInt(st.nextToken());
				int diff = Integer.parseInt(st.nextToken());
				list.add(new Problem(num, diff));
				map.put(num, diff);
			}else{
				int num = Integer.parseInt(st.nextToken());
				int diff = map.get(num);
				list.remove(new Problem(num, diff));
			}
		}

		System.out.println(sb);
	}
}
