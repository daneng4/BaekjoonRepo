
import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static ArrayList<Integer>[] tree;
	static int levels, size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		levels = Integer.parseInt(br.readLine());
		size = (int) (Math.pow(2, levels) - 1);
		arr = new int[size];
		tree = new ArrayList[levels];
		for(int i = 0; i<levels; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		search(0, 0, size);
		
		for(int i = 0; i<tree.length; i++) {
			for(int element : tree[i]) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
	}
	public static void search(int depth, int start, int end) {
		if(depth == levels)
			return;
		int mid = (start + end) / 2;
		int root = arr[mid];
		tree[depth].add(root);
		
		
		
		search(depth+1, start, mid-1);
		search(depth+1, mid+1, end);
	}
}
