import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       String[] s = new String[n];
       int count = 0;

       for(int i = 0; i<n; i++){
           s[i] = br.readLine();
       }

       for(int i = 0; i<m; i++){
           String str = br.readLine();
           for(int j = 0; j<n; j++){
               if(s[j].equals(str)){
                   count++;
                   break;
               }
           }
       }

        System.out.println(count);
    }
}