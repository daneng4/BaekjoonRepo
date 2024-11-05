import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size() > 1){
            int a = pq.poll();
            if(a >= K)
                break;
            int b = pq.poll();
            int sum = a + (b * 2);
            pq.add(sum);
            answer += 1;
        }
        
        if(pq.size() == 1 && pq.peek() < K)
            return -1;
        
        return answer;
    }
}