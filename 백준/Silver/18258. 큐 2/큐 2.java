
import java.util.*;
import java.io.*;

public class Main {
	static final String PUSH = "push";
	static final String POP = "pop";
	static final String FRONT = "front";
	static final String BACK = "back";
	static final String SIZE = "size";
	static final String EMPTY = "empty";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int number;
			if(op.equals(PUSH)) {
				number = Integer.parseInt(st.nextToken());
				q.add(number);
			}else if (op.equals(POP)) {
				if(q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.pollFirst()+ "\n");
			}else if(op.equals(SIZE))
				bw.write(q.size() + "\n");
			else if(op.equals(EMPTY)) {
				if(q.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			}else if(op.equals(FRONT)) {
				if(q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.peekFirst() + "\n");
			}else {
				if(q.isEmpty()){
					bw.write("-1\n");
				}else
					bw.write(q.peekLast() + "\n");
			}

		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}