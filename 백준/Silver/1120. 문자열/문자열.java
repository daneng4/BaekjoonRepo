import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        if(B.contains(A)){
            System.out.println(0);
            return;
        }

        int answer = Integer.MAX_VALUE;
        int end = B.length() - A.length();
        for(int i = 0; i<=end; i++){
            int count = 0;

            for(int j = 0; j<A.length(); j++){
                int idx = j + i;
                if(A.charAt(j) != B.charAt(idx))
                    count++;
            }

            answer = Math.min(count, answer);
        }

        System.out.println(answer);
    }
}