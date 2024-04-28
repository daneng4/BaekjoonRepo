import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities){
            pq.add(p);
        }
        Queue<Number> q = new LinkedList<>();
        for(int i = 0; i<priorities.length; i++){
            q.add(new Number(priorities[i], i));
        }
        
        int count = 1;
        while(!pq.isEmpty()){
            int poll = pq.poll();
            while(q.peek().value != poll){
                q.add(q.poll());
            }
            Number n = q.poll();
            if(n.loc == location){
                answer = count;
                break;
            }
            count++;
        }  
        return answer;
    }
}
class Number{
    int value;
    int loc;
    Number(int value, int loc){
        this.value = value;
        this.loc = loc;
    }
}