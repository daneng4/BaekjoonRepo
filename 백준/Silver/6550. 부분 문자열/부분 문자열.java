import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String s = br.readLine();
            if(s == null){
                break;
            }

            st = new StringTokenizer(s);
            String target = st.nextToken();
            String sample = st.nextToken();
            int idx = 0;

            for(int i = 0; i<sample.length(); i++){
                if(target.charAt(idx) == sample.charAt(i)){
                    idx += 1;
                }
                if(idx == target.length()){
                    break;
                }
            }

            if(idx == target.length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

    }
}
