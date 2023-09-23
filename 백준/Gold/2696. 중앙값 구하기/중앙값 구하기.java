import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            int m = Integer.parseInt(br.readLine());
            sb.append((m/2)+1).append("\n");
            int cnt = 0; //줄 간격 띄우기 위한 용도

            for(int i = 0; i<m; i++){
                if(i%10 == 0){ // 0, 10, 20 ... 에서 문자열 한 줄을 새로 입력 받음
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                Collections.sort(list);

                if(i%2 == 0){ // 인덱스는 0부터 시작이므로 짝수번째 인덱스에서 중앙값 출력
                    // 한 줄에 최대 10개
                    if(cnt == 9 || i == m-1){
                        sb.append(list.get(i/2)).append("\n");
                        cnt = 0;
                    }else {
                        sb.append(list.get(i / 2)).append(" ");
                    }
                    cnt++;
                }

            }

        }
        System.out.println(sb);

    }

}
