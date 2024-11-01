import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        for(int price : prices){
            q.add(price);
        }
        
        int index=0;
        while(!q.isEmpty()){
            int value = q.poll();
            answer[index] = 0;
            for(int e : q){
                answer[index]++;
                if(value > e)
                    break;
            }
            index++;
        }
        
        return answer;
    }
}
