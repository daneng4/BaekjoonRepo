import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(
            Comparator.comparingInt((int[] i) -> -i[0])
                    .thenComparingInt(i -> -i[1])
                    .thenComparingInt(i -> i[2]));

        // 장르별 총 재생 횟수 계산
        for (int i = 0; i < plays.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // [장르 총합, 곡 재생수, 고유번호]를 PQ에 삽입
        for (int i = 0; i < plays.length; i++) {
            pq.add(new int[] {genreMap.get(genres[i]), plays[i], i});
        }

        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            int genreTotal = pq.peek()[0];

            // 한 장르에서 최대 2곡까지 수록
            for (int i = 0; i < 2; i++) {
                if (pq.isEmpty() || pq.peek()[0] != genreTotal) break;
                answer.add(pq.poll()[2]);
            }

            // 해당 장르의 나머지 곡은 모두 제거
            while (!pq.isEmpty() && pq.peek()[0] == genreTotal) pq.poll();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}