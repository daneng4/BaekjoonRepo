
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Member> list = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Member(age, name));
		}
		
		Collections.sort(list);
		
		for(Member m : list) {
			bw.write(m.age + " " + m.name + "\n");
		}
		
		bw.flush();
	}		
}
class Member implements Comparable<Member>{
	int age;
	String name;
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(Member m) {
		return this.age - m.age;
	}
}