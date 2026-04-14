import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> prior = new ArrayList<>();
        Queue<Process> q = new ArrayDeque<>();
        
        for(int i = 0; i<priorities.length; i++){
            prior.add(priorities[i]);
            q.add(new Process(priorities[i], i));
        }
        
        Collections.sort(prior, Collections.reverseOrder());
        
        int idx = 0;
        int count = 1;
        
        while(true){
            Process process = q.peek();
            
            // 우선순위가 현재 우선순위와 맞다면 poll
            if(prior.get(idx) == process.prior){
                q.poll();
                idx++;
                
                if(location == process.location){
                    break;
                }
                
                count++;
            }else{
                q.add(q.poll());
            }
        }
        
        return count;
    }
}
class Process {
    int prior;
    int location;
    
    public Process(int prior, int location){
        this.prior = prior;
        this.location = location;
    }
}