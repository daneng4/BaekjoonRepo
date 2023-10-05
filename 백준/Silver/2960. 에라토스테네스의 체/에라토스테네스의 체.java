import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p;
        int remove = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 2; i<=n; i++){
            list.add(i);
        }

        while(!list.isEmpty()){
            p = list.get(0);
            for(int i = 0; i<list.size(); i++){
                int num = list.get(i);
                if(num % p == 0){
                    list.remove(i);
                    remove++;
                }
                if(remove == k){
                    System.out.println(num);
                    exit(0);
                }

            }
        }

    }
}