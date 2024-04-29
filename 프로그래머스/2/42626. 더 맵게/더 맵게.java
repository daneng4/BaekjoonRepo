import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }

        while(pq.size() > 1){
            int minHot = pq.peek();
            int minHot2 = pq.peek() * 2;
            if(minHot >= K && minHot2 >= K){
                break;
            }
            pq.add(pq.poll() + pq.poll()*2);
            answer++;
        }
        
        if(pq.size() == 1 && pq.peek() < K){
            return -1;
        }
        
        return answer;
    }
}