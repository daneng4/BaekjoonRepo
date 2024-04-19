
import java.util.*;
import java.io.*;

public class Solution {
	static int nodeCount;
	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = 10;
		for(int t = 1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			nodeCount = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			visit = new boolean[101];
			for(int i = 1; i<=100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<nodeCount/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b, 0));
			}
			
			answer = bfs(startNode);
			
			bw.write(String.format("#%d %d\n", t, answer));
		}// end of tc
		bw.flush();
	}
	public static int bfs(int startNode) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startNode, 1));
		int highDepth = -1;
		int highDepthNode = -1;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			int curNode = poll.end;
			int curDepth = poll.depth;
			
			if(visit[curNode]) continue;
			visit[curNode] = true;
			
			// 가장 깊은 깊이 갱신
			// 만약 현재 깊이가 highDepth와 같은 경우
			if(highDepth == curDepth) {
				// 현재 노드 번호가 가장 깊은 노드번호보다 큰 경우
				if(curNode > highDepthNode) {
					highDepthNode = curNode;
				}
				
			}else if(curDepth > highDepth) {
				highDepthNode = curNode;
				highDepth = curDepth;
			}
			
			for(Node next : list[curNode]) {
				q.add(new Node(next.end, curDepth+1));
			}
			
		}
		return highDepthNode;
	}
}
class Node{
	int end;
	int depth;
	Node(int end, int depth){
		this.end = end;
		this.depth = depth;
	}
}
