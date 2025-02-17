import java.util.*;

class Lecture implements Comparable<Lecture> {
    int pay;
    int day;

    Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture other) {
        return this.day - other.day; // 마감일을 기준으로 오름차순 정렬
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            lectures[i] = new Lecture(pay, day);
        }

        // 마감일을 기준으로 강연 정렬
        Arrays.sort(lectures);

        // 우선순위 큐 (최소 힙) 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lecture lecture : lectures) {
            pq.offer(lecture.pay); // 현재 강연의 강연료를 큐에 추가
            if (pq.size() > lecture.day) {
                pq.poll(); // 큐의 크기가 마감일보다 크면 가장 작은 값 제거
            }
        }

        // 우선순위 큐에 남아있는 강연료의 합 계산
        int totalPay = 0;
        while (!pq.isEmpty()) {
            totalPay += pq.poll();
        }

        System.out.println(totalPay);
    }
}
