import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for(int i = 0; i<n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i<w; i++){
            bridge.add(0);
        }

        int passed = 0; // 다리를 건너간 트럭의 개수를 세는 변수
        int currentL = 0; // 현재 다리 하중
        int time = 0; // 시간

        while (passed != n) {
            // 트럭이 전부 지나갔다면 종료

            // 다리의 맨 앞이 빠져나간다. 빠져나가며 무게도 갱신된다.
            int out = bridge.poll();
            if (out > 0)
                passed++;
            currentL -= out;

            // 트럭 투입 여부를 결정한다. 더이상 투입될 트럭이 없다면 add 0
            if (!truck.isEmpty()) {

                // 다음 투입될 트럭 + 현재 다리 하중이 최대 하중 이하라면 가능
                if (currentL + truck.peek() <= L) {
                    int currentTruck = truck.poll();
                    bridge.add(currentTruck);

                    // 무게를 갱신해준다.
                    currentL += currentTruck;
                } else {
                    bridge.add(0);
                }

            } else {
                bridge.add(0);
            }

            time++;
        }

        System.out.println(time);
    }
}