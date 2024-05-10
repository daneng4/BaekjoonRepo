import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Node> list;
	static StringBuilder sb;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = 10;
		
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			visit = new boolean[n+1];
			sb = new StringBuilder();
			list = new ArrayList<>();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken());
				char word = st.nextToken().charAt(0);
				Integer left = null;
				Integer right = null;
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens())
						right = Integer.parseInt(st.nextToken());
				}
				
				list.add(new Node(cur, left, right, word));
			}
			
			dfs(1);
			
			bw.write(String.format("#%d %s\n", t, sb.toString()));
		} // testcase
		bw.flush();
	}
	public static void dfs(int cur) {
		// 현재 노드의 왼쪽 자식 노드
		Integer leftNode = list.get(cur-1).left;
		Integer rightNode = list.get(cur-1).right;
		// 현재 노드의 왼쪽 자식이 있다면
		if(leftNode != null) {
			dfs(leftNode);
		}
		
		// 현재 노드의 word를 builder에 담는다
		sb.append(list.get(cur-1).word);
		if(rightNode != null)
			dfs(rightNode);
	}
}
class Node{
	int curNode;
	Integer left;
	Integer right;
	char word;
	Node(int curNode, Integer left, Integer right, char word){
		this.curNode = curNode;
		this.left = left;
		this.right = right;
		this.word = word;
	}
}