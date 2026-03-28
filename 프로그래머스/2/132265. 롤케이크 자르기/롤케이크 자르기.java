import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> me = new HashMap<>();
        Set<Integer> bro = new HashSet<>();
        
        for(int t : topping){
            me.put(t, me.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            bro.add(t);
            me.put(t, me.get(t) - 1);
            
            if(me.get(t) == 0)
                me.remove(t);
            
            if(me.size() == bro.size()){
                answer++;
            }
        }
        
        
        return answer;
    }
}