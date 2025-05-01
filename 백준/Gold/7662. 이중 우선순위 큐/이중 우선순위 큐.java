import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> list;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0){
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st;
			list = new TreeMap<>();

			while(k-- > 0){
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if(op == 'D'){
					if(list.isEmpty())
						continue;

					if(num == 1){
						if(list.get(list.lastKey()) == 1){
							list.remove(list.lastKey());
						}else{
							list.put(list.lastKey(), list.get(list.lastKey()) - 1);
						}
					}else{
						if(list.get(list.firstKey()) == 1){
							list.remove(list.firstKey());
						}else{
							list.put(list.firstKey(), list.get(list.firstKey()) - 1);
						}
					}
				}else{
					list.put(num, list.getOrDefault(num, 0) + 1);
				}
			}

			// 연산 수행 이후 최대, 최소
			if(list.isEmpty())
				sb.append("EMPTY\n");
			else
				sb.append(list.lastKey() + " " + list.firstKey() + "\n");
		}

		System.out.println(sb);
	}
}
