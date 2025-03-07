import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static class Order{
        String Op;
        char alpa;
        int curTime;
        int backTime;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Order[] orders = new Order[n];
        boolean[] check = new boolean[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            orders[i] = new Order();
            if (st.nextToken().equals("type")) {
                orders[i].Op = "type";
                orders[i].alpa = st.nextToken().charAt(0);
                orders[i].curTime = Integer.parseInt(st.nextToken());
            } else {
                orders[i].Op = "undo";
                orders[i].backTime = Integer.parseInt(st.nextToken());
                orders[i].curTime = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = n-1; i>=0; i--){
            if(check[i] || !orders[i].Op.equals("undo"))
                continue;

            check[i] = true;
            int look = orders[i].curTime - orders[i].backTime;

            for(int j = i-1; j>=0; j--){
                if(look > orders[j].curTime){
                    break;
                }
                check[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (check[i])
                continue;
            sb.append(orders[i].alpa);
        }
        System.out.println(sb);
    }
}
