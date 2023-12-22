
import java.io.*;
import java.util.*;

public class Main {
	
	static List<String>[] list;
	static Map<String, Integer> dna;
	static List<String> result;
	static int hdSum = 0;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dna = new HashMap<>();
		result = new ArrayList<>();
		list = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<n; i++) {
			String[] split = br.readLine().split("");
			for(String str : split) {
				list[i].add(str);
			}
		}
		for(int i = 0; i<m; i++) {
			initDNA();
			findMostDNA(i);
		}
		
		for(String str : result) {
			System.out.print(str);
		}
		System.out.println();
		System.out.println(hdSum);
		
	}
	public static void findMostDNA(int index) {
		int max = Integer.MIN_VALUE;
		String keyDna = null;
		
		for(int i = 0; i<list.length; i++) {
			String str = list[i].get(index);
			dna.put(str, dna.get(str)+1);
		}
		
		for(Map.Entry<String, Integer> entry : dna.entrySet()) {
			if(entry.getValue() > max) {
				keyDna = entry.getKey();
				max = entry.getValue();
			}else if (entry.getValue() == max) {
				int asc = (int)entry.getKey().charAt(0);
				int maxAsc = (int)keyDna.charAt(0);
				if(asc - maxAsc < 0) {
					keyDna = entry.getKey();
					max = entry.getValue();
				}
					
			}
		}
		result.add(keyDna);
		
		for(Map.Entry<String, Integer> entry : dna.entrySet()) {
			if(entry.getKey().equals(keyDna)) 
				continue;
			hdSum += entry.getValue();
		}
		
	}
	
	public static void initDNA() {
		for(int i = 0; i<4; i++) {
			dna.put("A", 0); dna.put("C", 0); dna.put("G", 0); dna.put("T", 0);
		}
	}
}
