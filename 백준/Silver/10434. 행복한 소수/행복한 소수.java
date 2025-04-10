import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int caseNumber = Integer.parseInt(st.nextToken());
            String m = st.nextToken();
            int mToInt = Integer.parseInt(m);

            if(!isPrime(mToInt) || mToInt == 1){
                sb.append(caseNumber).append(" ").append(m).append(" NO\n");
                continue;
            }

            boolean flag = false;
            ArrayList<Integer> list = new ArrayList<>();
            while(true){
                int result = 0;

                for(int i = 0; i<m.length(); i++){
                    result += (int)Math.pow(m.charAt(i) - '0', 2);
                }

                if(result == 1){
                    flag = true;
                    break;
                }
                if(list.contains(result)){
                    break;
                }
                list.add(result);
                m = String.valueOf(result);
            }

            if(flag){
                sb.append(caseNumber).append(" ").append(mToInt).append(" YES\n");
            }else{
                sb.append(caseNumber).append(" ").append(mToInt).append(" NO\n");
            }
        }

        System.out.println(sb);
    }
    static boolean isPrime(int m){
        for(int i = 2; i<=Math.sqrt(m); i++){
            if(m % i == 0)
                return false;
        }

        return true;
    }
}
