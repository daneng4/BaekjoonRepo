
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		int answer[] = new int[n];
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 0; i < n; i++) {
			
			while(!st.empty() && nums[st.peek()] < nums[i]) {
				answer[st.pop()] = nums[i];
			}
			st.push(i);
		}
		
		while(!st.empty()) {
			answer[st.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}
