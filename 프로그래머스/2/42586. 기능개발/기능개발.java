import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> prog = new ArrayList<>();
        List<Integer> spd = new ArrayList<>();
        List<Integer> tmp;
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<progresses.length; i++){
            prog.add(progresses[i]);
            spd.add(speeds[i]);
        }
        
        while(prog.size() != 0){
            tmp = new ArrayList<>();
            for(int i = 0; i<prog.size(); i++){
                prog.set(i, prog.get(i) + spd.get(i));
            }
            if(prog.get(0) < 100)
            	continue;
            int count = 0;
            for(int i = 0; i<prog.size(); i++){
                if(prog.get(i) >= 100){
                    count++;
                }
                else
                    break;
            }
            if(count >= 1) {
            	for(int i = count-1; i>-1; i--) {
            		prog.remove(i);
            		spd.remove(i);
            	}
                result.add(count);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}