import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] info = new Info[n];

        StringTokenizer st = null;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year  = Integer.parseInt(st.nextToken());

            info[i] = new Info(name, day, month, year);
        }

        Arrays.sort(info, (o1, o2) -> {
            if(o1.year == o2.year){
                return o1.month - o2.month;
            }else if(o1.month == o2.month){
                return o1.day - o2.day;
            }
            return o1.year - o2.year;
        });

        StringBuilder sb = new StringBuilder();
        sb.append(info[info.length-1].name + "\n");
        sb.append(info[0].name);
        System.out.println(sb);
    }
}
class Info{
    String name;
    int day;
    int month;
    int year;

    public Info(String name, int day, int month, int year){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
