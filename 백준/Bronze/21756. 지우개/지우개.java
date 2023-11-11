
import java.io.*;
import java.util.*;


public class Main {
	public static ArrayList<Integer> arr;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=num; i++) {
			arr.add(i);
		}
		while(arr.size() != 1) {
			for(int i = 1; i<=arr.size(); i++) {
				if(i%2 == 1) {
					q.add(arr.get(i-1));
				}
			}
			while(!q.isEmpty()) {
				int targetN = q.poll();
				for(int i = 1; i<=arr.size(); i++) {
					if(arr.get(i-1).equals(targetN)) {
						arr.remove(i-1);
					}
				}
			}
		}
		System.out.println(arr.get(0));
		
	}
}
