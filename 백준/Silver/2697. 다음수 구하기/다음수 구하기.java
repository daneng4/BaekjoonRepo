import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            String arr = br.readLine();
            int pre = arr.charAt(arr.length() - 1) - '0';
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pre);

            int lower = 0;
            int idx;
            StringBuilder str = new StringBuilder();
            boolean flag = false;

            for(int i = arr.length()-2; i>=0; i--){
                int num = arr.charAt(i) - '0';

                if(num < pre){
                    flag = true;
                    idx = i;
                    str = new StringBuilder(arr.substring(0, idx));
                    lower = num;
                    list.add(num);
                    break;
                }

                list.add(num);
                pre = num;
            }

            if(!flag){
                sb.append("BIGGEST\n");
                continue;
            }

            Collections.sort(list);
            for(int i = 0; i<list.size(); i++){
                if(list.get(i) > lower){
                    str.append(list.get(i));
                    list.remove(i);
                    break;
                }
            }

            for(int num : list){
                str.append(num);
            }

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
