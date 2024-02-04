
import java.util.*;
import java.io.*;

public class Main {

	static Map<String, int[]> leftKb = new HashMap<>();
	static Map<String, int[]> rightKb = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		setKeyBoard();
		String start1 = st.nextToken();
		String start2 = st.nextToken();

		int[] curLeft = leftKb.get(start1);
		int[] curRight = rightKb.get(start2);
		String[] str = br.readLine().split("");
		int result = 0;
		
		for(String word : str) {
			if(leftKb.containsKey(word)) {
				int[] targetPos = leftKb.get(word);
				result += Math.abs(targetPos[0] - curLeft[0]) + Math.abs(targetPos[1] - curLeft[1])+1;
				curLeft = targetPos;
			}else {
				int[] targetPos = rightKb.get(word);
				result += Math.abs(targetPos[0] - curRight[0]) + Math.abs(targetPos[1] - curRight[1])+1;
				curRight = targetPos;
			}
		}
		System.out.println(result);
	}

	
	public static void setKeyBoard() {
		
		leftKb.put("q", new int[]{0, 0});
        leftKb.put("w", new int[]{0, 1});
        leftKb.put("e", new int[]{0, 2});
        leftKb.put("r", new int[]{0, 3});
        leftKb.put("t", new int[]{0, 4});
        rightKb.put("y", new int[]{0, 5});
        rightKb.put("u", new int[]{0, 6});
        rightKb.put("i", new int[]{0, 7});
        rightKb.put("o", new int[]{0, 8});
        rightKb.put("p", new int[]{0, 9});

        leftKb.put("a", new int[]{1, 0});
        leftKb.put("s", new int[]{1, 1});
        leftKb.put("d", new int[]{1, 2});
        leftKb.put("f", new int[]{1, 3});
        leftKb.put("g", new int[]{1, 4});
        rightKb.put("h", new int[]{1, 5});
        rightKb.put("j", new int[]{1, 6});
        rightKb.put("k", new int[]{1, 7});
        rightKb.put("l", new int[]{1, 8});

        leftKb.put("z", new int[]{2, 0});
        leftKb.put("x", new int[]{2, 1});
        leftKb.put("c", new int[]{2, 2});
        leftKb.put("v", new int[]{2, 3});
        rightKb.put("b", new int[]{2, 4});
        rightKb.put("n", new int[]{2, 5});
        rightKb.put("m", new int[]{2, 6});
		
	}
}