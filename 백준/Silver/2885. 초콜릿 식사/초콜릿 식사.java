import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        int size = 1;
        while(size < k){
            size *= 2;
        }
        sb.append(size).append(" ");

        if(k == size){
            sb.append(0);
        }else{
            int count = 0;
            int curSize = 0;
            while(curSize != k){
                size /= 2;
                curSize += size;
                if(curSize > k){
                    curSize -= size;
                }
                count++;
            }
            sb.append(count);
        }

        System.out.println(sb);
    }
}
