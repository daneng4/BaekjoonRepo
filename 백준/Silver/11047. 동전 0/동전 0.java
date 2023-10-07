import java.util.*;
import java.io.*;

public class Main  {

    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            if(coin > k)
                continue;

            list.add(coin);
        }
        list.sort(Collections.reverseOrder());
        int result = 0;
        for(int i = 0; i<list.size(); i++){
            result += k / list.get(i);
            k = k % list.get(i);
            if(k == 0){
                System.out.println(result);
                break;
            }

        }

    }
}