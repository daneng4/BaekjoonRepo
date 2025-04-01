import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        int maxLength = 0;
        int len = target.length();
        // 시작 위치
        for(int i = 0; i<len; i++){
            // 마지막 위치
            for(int j = i+2; j<=len; j+=2){
                String subStr = target.substring(i, j);

                int forwardSum = 0;
                int behindSum = 0;

                for(int k = 0; k<subStr.length()/2; k++){
                    forwardSum += subStr.charAt(k) - '0';
                    behindSum += subStr.charAt(k + subStr.length()/2) - '0';
                }

                if(forwardSum == behindSum){
                    maxLength = Math.max(maxLength, subStr.length());
                }
            }
        }

        System.out.println(maxLength);
    }
}
