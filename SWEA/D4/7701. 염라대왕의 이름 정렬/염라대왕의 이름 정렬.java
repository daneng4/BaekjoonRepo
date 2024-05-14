import java.util.*;
import java.io.*;

// 1. 정렬부터, 짧을수록 우선순위 같은길이? 사전순
// 2. 정렬 후 중복제거, HashSet에 삽입
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
        	ArrayList<Words> list = new ArrayList<>();
        	HashSet<String> set = new HashSet<>();
        	int n = Integer.parseInt(br.readLine());
        	for(int i = 0; i<n; i++) {
        		String str = br.readLine();
        		set.add(str);
        	}
        	
        	for(String s : set) {
        		list.add(new Words(s));
        	}
        	
        	Collections.sort(list);
        	StringBuilder sb = new StringBuilder();
        	
        	for(Words w : list) {
        		sb.append(w.word).append("\n");
        	}
        	
        	bw.write(String.format("#%d\n%s", tc, sb.toString()));
        }// tc
        bw.flush();
    }	
}
class Words implements Comparable<Words>{
	String word;
	int len;
	Words(String word){
		this.word = word;
		this.len = word.length();
	}
	public int compareTo(Words w) {
		// 길이가 같다면 사전순
		if(len == w.len) {
			return word.compareTo(w.word);
		}
		return len - w.len;
	}
}