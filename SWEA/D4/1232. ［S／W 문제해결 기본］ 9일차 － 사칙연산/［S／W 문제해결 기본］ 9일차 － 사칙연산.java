import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static Node[] nodes;
	static char[] operator = {'+','-','*','/'};
	static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = 10;

        for (int tc = 1; tc <= t; tc++) {
        	n = Integer.parseInt(br.readLine());
        	nodes = new Node[n+1];

        	for(int i = 0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		int nodeNumber = Integer.parseInt(st.nextToken());
        		String op = st.nextToken();
        		
        		if(checkOp(op)) {
        			Integer leftIdx = Integer.parseInt(st.nextToken());
        			Integer rightIdx = Integer.parseInt(st.nextToken());
        			nodes[nodeNumber] = new Node(0, op, leftIdx, rightIdx);
        		}else {
        			int value = Integer.parseInt(op);
        			nodes[nodeNumber] = new Node(value, null, null, null);
        		}
        			
        	}
        	int result = dfs(1);
        	
        	bw.write(String.format("#%d %d\n", tc, result));
        }// tc
        bw.flush();
    }
    public static boolean checkOp(String op) {
    	for(int i = 0; i<4; i++) {
    		if(op.charAt(0) == operator[i])
    			return true;
    	}
    	return false;
    }
    public static int dfs(int root) {
    	if(nodes[root].op != null) {
    		Integer left = nodes[root].leftIdx;
        	Integer right = nodes[root].rightIdx;
        	String op = nodes[root].op;
        	// 왼쪽 노드가 존재한다면 오른쪽 노드도 존재하고 이 노드는 연산자 노드임
    		if(op.equals("+"))
    			return dfs(left) + dfs(right);
    		else if(op.equals("-"))
    			return dfs(left) - dfs(right);
    		else if(op.equals("*"))
    			return dfs(left) * dfs(right);
    		else
    			return dfs(left) / dfs(right);
    	}else {
    		return nodes[root].value;
    	}
    }
}
class Node{
	int value;
	String op;
	Integer leftIdx;
	Integer rightIdx;
	Node(int value, String op, Integer leftIdx, Integer rightIdx){
		this.value = value;
		this.op = op;
		this.leftIdx = leftIdx;
		this.rightIdx = rightIdx;
	}
}
