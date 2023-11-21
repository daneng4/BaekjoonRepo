
import java.io.*;
import java.util.*;

public class Main {

	public static String mode;
	public static int value = 0;
	public static ArrayList<Integer> list;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		while(n-- >0) {
			value = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.countTokens() == 1) {
				mode = st.nextToken();
			}else {
				mode = st.nextToken();
				value = Integer.parseInt(st.nextToken());
			}
			operation();
		}
		
		System.out.println(sb);
	}
	public static void operation() {

		if(value != 0) { // empty & all 을 제외한 명령어 수행
			if(mode.equals("add")) {
				if(!list.contains(value))
					list.add(value);
			}else if (mode.equals("remove")) {
				if(list.contains(value)) {
					int idx = list.indexOf(value);
					list.remove(idx);
				}
			}else if (mode.equals("check")) {
				if(list.contains(value))
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
			}else if (mode.equals("toggle")) {
				if(list.contains(value)) {
					int idx = list.indexOf(value);
					list.remove(idx);
				}else {
					list.add(value);
				}
			}
			return;
		} // end of if( value!=0 )
		else if (mode.equals("all")) { // all 명령어 수행
			list.removeAll(list);
			for(int i = 1; i<=20; i++)
				list.add(i);
		}else { // empty 명령어 수행
			list.removeAll(list);
		}

	}
}
