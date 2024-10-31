import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Prior> queue = new LinkedList<>();
        Integer[] values = new Integer[priorities.length];
        
        for(int i = 0; i<priorities.length; i++){
            values[i] = priorities[i];
            
            if(location == i){
                queue.add(new Prior(priorities[i], true));
            }else{
                queue.add(new Prior(priorities[i], false));
            }
        }
        
        Arrays.sort(values, (a,b) -> b-a );
        int idx = 0;
        
        while(!queue.isEmpty()){
            Prior poll = queue.poll();
            if(poll.target && poll.p == values[idx]) 
            	break;
            else if(poll.p == values[idx]){
            	if(idx < values.length)
            		idx += 1;
                answer += 1;
                continue;
            }
            queue.add(poll);
        }
        
        return answer;
    }
}
class Prior {
    int p;
    boolean target;
    public Prior(int p, boolean target){
        this.p = p;
        this.target = target;
    }
}