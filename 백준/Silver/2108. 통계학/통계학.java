
import java.io.*;
import java.util.*;

/*
 * 산술평균 : 그냥 합을 구하면 된다
 * 중앙값 : 정렬 필요, 시간초과는 안날거같음
 * 최빈값 : 가장 많이 나타나는 값, 데이터를 입력 받으며 세주면 될듯?
 * 범위 : 정렬 필요, 중앙값을 구하며 같이 구하면 될듯
 */

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			int number = Integer.parseInt(br.readLine());
			numbers.add(number);
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(numbers);
		
		sb.append(avg(numbers)).append("\n");
		sb.append(mid(numbers)).append("\n");
		sb.append(frequency(numbers)).append("\n");
		sb.append(range(numbers)).append("\n");
		System.out.println(sb);
	}
	public static int avg(ArrayList<Integer> numbers) {
		double sum = 0;
		for(double number : numbers) {
			sum += number;
		}
		double avg = sum/numbers.size();
		return (int) Math.round(avg);
	}
	public static int mid(ArrayList<Integer> numbers) {
		return numbers.get((numbers.size()-1)/2);
	}
	public static int frequency(ArrayList<Integer> numbers) {
		// 최빈값, 가장 많이 나온 값, 여러개면 두번째로 작은 값을 구한다.
		Map<Integer,Integer> map = new TreeMap<>();
		int maxCount = 0;
		for(int number : numbers) {
			map.put(number, map.getOrDefault(number, 0)+1);
			int count = map.get(number);
			if(count > maxCount)
				maxCount = count;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int key :map.keySet()) {
			if(map.get(key) == maxCount)
				q.add(key);
		}
		
		if(q.size() > 1) {
			q.poll();
			return q.poll();
		}else {
			return q.poll();
		}
			
	}
	public static int range(ArrayList<Integer> numbers) {
		return Collections.max(numbers) - Collections.min(numbers);
	}
}
