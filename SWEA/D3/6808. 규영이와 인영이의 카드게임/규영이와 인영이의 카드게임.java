import java.io.*;
import java.util.*;

class Solution {
	static boolean[] nums;
	static int[] gnum;
	static int[] inum;
	static int[] icards;
	static boolean[] visit;
	static int win, lose;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			nums = new boolean[19];
			gnum = new int[9]; // 규영
			inum = new int[9]; // 인영
			visit = new boolean[9]; 
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gnum[i] = num;
				nums[num] = true;
			}
			int idx = 0;
			for(int i = 1; i<19; i++) {
				if(!nums[i])
					inum[idx++] = i;
			}
			
			icards = new int[9];
			win = 0; lose = 0;
			checkSeq(0);
			
			bw.write(String.format("#%d %d %d\n", test_case, win, lose));
		
		} // end of testcase
		bw.flush();
	}
	public static void checkSeq(int count){
		if(count == icards.length) {
			cal();
			return;
		}
		
		for(int i = 0; i<icards.length; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			icards[count] = inum[i];
			checkSeq(count+1);
			visit[i] = false;
		}
	}
	
	public static void cal() {
		int gpoint = 0;
		int ipoint = 0;
		for(int i = 0; i<9; i++) {
			if(gnum[i] > icards[i]) {
				gpoint += gnum[i] + icards[i];
			}else {
				ipoint += gnum[i] + icards[i];
			}
		}
		
		if(gpoint > ipoint)
			win++;
		else
			lose++;
	}
}
