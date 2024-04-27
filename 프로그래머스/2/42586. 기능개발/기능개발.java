import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int idx = 0;
        
        for(int p : progresses){
            int remain = (100 - p) / speeds[idx];
            if((100-p) % speeds[idx] > 0)
                remain+=1;
            idx++;
            
            if(s.isEmpty()){
                s.push(remain);
                max = Math.max(remain, max);
            }
            else{
                
                if(max >= remain){
                    s.push(remain);
                    max = Math.max(max, remain);
                }else{
                    int count = 0;
                    while(!s.isEmpty()){
                        s.pop();
                        count++;
                    }
                    s.push(remain);
                    max = remain;
                    answer.add(count);
                }
                
            }
        }
        int last = 0;
        while(!s.isEmpty()) {
        	s.pop();
        	last++;
        	
        }
        answer.add(last);
        return answer;
    }
}