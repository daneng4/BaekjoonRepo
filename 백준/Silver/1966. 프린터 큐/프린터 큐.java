import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> docq; // 문서 넣는 큐
    static Queue<Integer> arrayq; // 문서 순서넣는 큐
    static int m;
    static int n;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<t; i++){
            docq = new LinkedList<>();
            arrayq = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 문서의 개수
            m = Integer.parseInt(st.nextToken()); // 타깃 문서의 현재 순서
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<n; j++){
                docq.offer(Integer.parseInt(st.nextToken()));
                arrayq.offer(j);
            }

            solve();
        }
    }
    public static void solve(){
        int count = 1; // 순서

        while(!docq.isEmpty()){ // 큐가 비기 전까지 반복
            int max = Collections.max(docq);
            int curdoc = docq.poll();
            int curindex = arrayq.poll();
            if(curdoc == max){ // 현재 문서가 중요도가 최대치인 문서일경우
                if(curindex == m){ // 타깃 문서였다면
                    System.out.println(count); // 출력
                    break;
                }
                count++; // 아니면 count 증가
            }else{
                docq.offer(curdoc);
                arrayq.offer(curindex);
            }

        }
    }
}