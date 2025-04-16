import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            need[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = start + p - 1;
        for(int i = start; i<=end; i++){
            char c = dna.charAt(i);
            if(c == 'A'){
                need[0]--;
            }else if(c == 'C'){
                need[1]--;
            }else if(c == 'G'){
                need[2]--;
            }else{
                need[3]--;
            }
        }

        int answer = 0;
        if(check(need))
            answer++;

		while (end < s - 1) {

			char sc = dna.charAt(start);
			if (sc == 'A') {
				need[0]++;
			} else if (sc == 'C') {
				need[1]++;
			} else if (sc == 'G') {
				need[2]++;
			} else {
				need[3]++;
			}
			start++;
			end++;

			sc = dna.charAt(end);
			if (sc == 'A') {
				need[0]--;
			} else if (sc == 'C') {
				need[1]--;
			} else if (sc == 'G') {
				need[2]--;
			} else {
				need[3]--;
			}

			if (check(need)) {
				answer++;
			}
		}

        System.out.println(answer);
    }
    static boolean check(int[] need){
        for(int i = 0; i<4; i++){
            if(need[i] > 0)
                return false;
        }
        return true;
    }
}
