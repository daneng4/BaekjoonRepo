import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        
        while(true){
            if(n == 0)
                break;
            if(pq.peek() == 0)
                break;
            
            int pollNum = pq.poll();
            pq.add(pollNum - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
}